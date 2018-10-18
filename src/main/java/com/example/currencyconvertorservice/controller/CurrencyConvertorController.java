package com.example.currencyconvertorservice.controller;

import com.example.currencyconvertorservice.controller.proxy.CurrencyExchangeProxy;
import com.example.currencyconvertorservice.domain.CurrencyConvertorBean;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CurrencyConvertorController {

    @Autowired
    private CurrencyExchangeProxy proxy;

//    @GetMapping("/exchangeAmount/from/{from}/to/{to}/qty/{qty}")
//    public CurrencyConvertorBean getConvertedAmount(@PathVariable("from")String from,
//                                                    @PathVariable("to")String to,
//                                                    @PathVariable("qty")int qty){
//        CurrencyConvertorBean currencyConvertorBean = new RestTemplate()
//                .getForObject("http://localhost:8000/exchange/from/{from}/to/{to}",
//                CurrencyConvertorBean.class,from,to);
//        currencyConvertorBean.setQuantity(qty);
//        currencyConvertorBean.setConvertedAmount(qty*currencyConvertorBean.getConversionMultiple());
//        return currencyConvertorBean;
//    }

    @GetMapping("/convert/from/{from}/to/{to}/qty/{qty}")
    public CurrencyConvertorBean getConvertedAmount(@PathVariable("from")String from,
                                                    @PathVariable("to")String to,
                                                    @PathVariable("qty")int qty){
        CurrencyConvertorBean currencyConvertorBean = proxy.retrieveExchangeValue(from,to);
        currencyConvertorBean.setQuantity(qty);
        currencyConvertorBean.setConvertedAmount(qty*currencyConvertorBean.getConversionMultiple());
        
        log.info("{}",currencyConvertorBean);
        return currencyConvertorBean;
    }
}
