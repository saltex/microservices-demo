package com.example.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url="localhost:8000/")
@FeignClient(name = "netflix-zuul-api-getway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConvertionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
