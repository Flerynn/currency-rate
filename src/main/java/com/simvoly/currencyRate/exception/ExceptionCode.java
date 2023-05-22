package com.simvoly.currencyRate.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode{
    GENERAL_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Undefined exception has occurred"),
    INVALID_CURRENCY_VALUE(HttpStatus.BAD_REQUEST, "Invalid currency rate value"),
    ERROR_CONSUMING_3RD_PARTY(HttpStatus.BAD_REQUEST, "Error with third party");

    private final HttpStatus httpStatus;

    private final String message;

    ExceptionCode(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
