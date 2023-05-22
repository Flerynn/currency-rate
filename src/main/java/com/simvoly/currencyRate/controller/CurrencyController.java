package com.simvoly.currencyRate.controller;

import com.simvoly.currencyRate.model.CurrencyRateRequest;
import com.simvoly.currencyRate.model.CurrencyRateResponse;
import com.simvoly.currencyRate.service.ICurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *  ** Currency controller to handle currency requests
 */

@RestController
@RequestMapping("currency")
public class CurrencyController {

    private final ICurrencyRateService currencyRateService;

    public CurrencyController(@Autowired final ICurrencyRateService currencyRateService) {
        this.currencyRateService = currencyRateService;
    }

    @GetMapping("rate")
    public ResponseEntity<CurrencyRateResponse> getCurrentCurrencyRate(@RequestBody final CurrencyRateRequest request) {
        return ResponseEntity.ok(currencyRateService.getCurrentCurrencyRate(request));
    }
}
