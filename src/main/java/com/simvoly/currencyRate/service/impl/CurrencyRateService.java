package com.simvoly.currencyRate.service.impl;

import com.simvoly.currencyRate.exception.CurrencyRateException;
import com.simvoly.currencyRate.exception.ExceptionCode;
import com.simvoly.currencyRate.gateway.currencyrate.CurrencyApiGateway;
import com.simvoly.currencyRate.model.Currency;
import com.simvoly.currencyRate.model.CurrencyRateRequest;
import com.simvoly.currencyRate.model.CurrencyRateResponse;
import com.simvoly.currencyRate.service.ICurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

@Service
public class CurrencyRateService implements ICurrencyRateService {

    @Autowired
    private CurrencyApiGateway currencyApiGateway;

    @Override
    public CurrencyRateResponse getCurrentCurrencyRate(CurrencyRateRequest request) {
        validate(request);

        String currency = Currency.findByLabel(request.getCurrency()).toString();

        CurrencyRateResponse response = new CurrencyRateResponse();
        response.setCurrencyRate(currencyApiGateway.getLatestExchangeRate(currency).getExchangeRate());
        response.setTimeStamp(Instant.now().getEpochSecond());

        return response;
    }
    private void validate(CurrencyRateRequest request) {
        if(Objects.isNull(Currency.findByLabel(request.getCurrency()))){
            throw new CurrencyRateException(ExceptionCode.INVALID_CURRENCY_VALUE);
        }
    }
}
