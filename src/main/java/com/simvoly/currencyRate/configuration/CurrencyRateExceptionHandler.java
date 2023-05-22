package com.simvoly.currencyRate.configuration;

import com.simvoly.currencyRate.exception.CurrencyRateException;
import com.simvoly.currencyRate.exception.ExceptionModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RestControllerAdvice
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CurrencyRateExceptionHandler extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CurrencyRateException exception) {
            // logging..
        }
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> handle(final CurrencyRateException exception){
        return new ResponseEntity<>(new ExceptionModel(exception.getExceptionCode()), exception.getExceptionCode().getHttpStatus());
    }
}
