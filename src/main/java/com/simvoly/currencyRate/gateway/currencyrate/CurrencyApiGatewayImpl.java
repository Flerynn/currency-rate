package com.simvoly.currencyRate.gateway.currencyrate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simvoly.currencyRate.exception.CurrencyRateException;
import com.simvoly.currencyRate.exception.ExceptionCode;
import com.simvoly.currencyRate.gateway.currencyrate.model.CurrencyApiResponse;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CurrencyApiGatewayImpl implements CurrencyApiGateway{

    @Value("${currencyApi.apiKeyName}")
    private String apiKeyName;

    @Value("${currencyApi.apiKeyValue}")
    private String apiKeyValue;

    @Value("${currencyApi.url}")
    private String currencyApiURL;

    @Value("${currencyApi.currencyQueryName}")
    private String currencyQueryName;

    private final HttpClient httpClient;
    private final ObjectMapper mapper;

    public CurrencyApiGatewayImpl(HttpClient httpClient, ObjectMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;

    }
    @Override
    public CurrencyApiResponse getLatestExchangeRate(String currency) {
        CurrencyApiResponse currencyApiResponse = new CurrencyApiResponse();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(addCurrencyQueryParam(currency)))
                    .GET()
                    .setHeader(apiKeyName, apiKeyValue)
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode newNode = mapper.readTree(response.body());
            currencyApiResponse.setExchangeRate(newNode.path("data").path(currency).path("value").doubleValue());
        } catch (Exception e) {
            throw new CurrencyRateException(ExceptionCode.ERROR_CONSUMING_3RD_PARTY);
        }
        return currencyApiResponse;
    }

    private String addCurrencyQueryParam(String currency){
        return currencyApiURL + "?" + currencyQueryName + "=" + currency;
    }
}
