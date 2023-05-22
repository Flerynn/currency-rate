package com.simvoly.currencyRate.gateway.currencyrate;

import com.simvoly.currencyRate.gateway.currencyrate.model.CurrencyApiResponse;

import java.io.IOException;

/**
 *
 *  ** Currency API GateWay
 */
public interface CurrencyApiGateway {
    CurrencyApiResponse getLatestExchangeRate(String currency);
}
