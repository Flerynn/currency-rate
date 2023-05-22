package com.simvoly.currencyRate.exception;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *  ** Application Exception
 */
@Getter
@Setter
public class CurrencyRateException extends RuntimeException {
    protected ExceptionCode exceptionCode;

    protected String exceptionMessage;

    public CurrencyRateException(final ExceptionCode exceptionCode){
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionCode.getMessage();
    }
}
