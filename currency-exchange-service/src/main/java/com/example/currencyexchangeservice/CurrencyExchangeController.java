package com.example.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue() {
        ExchangeValue value = new ExchangeValue(100L, "UAH", "USD", BigDecimal.valueOf(27));
        value.setPort(environment.getProperty("local.server.port"));
        return value;
    }
}
