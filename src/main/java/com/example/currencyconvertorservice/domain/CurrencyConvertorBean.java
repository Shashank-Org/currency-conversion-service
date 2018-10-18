package com.example.currencyconvertorservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConvertorBean {
    private int id;
    private String currencyFrom;
    private String currencyTo;
    private double conversionMultiple;
    private double quantity;
    private double convertedAmount;
    private int port;
}
