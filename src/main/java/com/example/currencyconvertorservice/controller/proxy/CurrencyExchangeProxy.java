package com.example.currencyconvertorservice.controller.proxy;


import com.example.currencyconvertorservice.domain.CurrencyConvertorBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "url" attribute of @FeignClient is not required if we r using ribbon
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

//    @GetMapping("/exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/exchange/from/{from}/to/{to}")
    CurrencyConvertorBean retrieveExchangeValue(@PathVariable("from") String from,
                                               @PathVariable("to") String to);

}
