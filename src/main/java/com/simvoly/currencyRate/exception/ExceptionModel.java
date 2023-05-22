package com.simvoly.currencyRate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionModel {
    private final String message;

    public ExceptionModel(final ExceptionCode exceptionCode) {
        this.message = exceptionCode.getMessage();
    }
}
