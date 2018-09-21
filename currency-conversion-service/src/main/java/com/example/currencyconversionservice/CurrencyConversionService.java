package com.example.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionService {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertionBean conversionServiceFiegn(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConvertionBean response = currencyExchangeProxy.retrieveExchangeValue(from, to);
        return new CurrencyConvertionBean(from,to,response.getQuantity(), response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()), "0");
    }
}
