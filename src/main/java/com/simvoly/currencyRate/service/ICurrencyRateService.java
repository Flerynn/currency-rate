package com.simvoly.currencyRate.service;

import com.simvoly.currencyRate.model.CurrencyRateRequest;
import com.simvoly.currencyRate.model.CurrencyRateResponse;

public interface ICurrencyRateService {


    /**
     *  return the exchange rate based on request
     *
     */
    CurrencyRateResponse getCurrentCurrencyRate(CurrencyRateRequest request);
}
