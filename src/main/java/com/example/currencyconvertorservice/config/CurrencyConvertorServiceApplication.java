package com.example.currencyconvertorservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.currencyconvertorservice")
@EnableFeignClients(basePackages = "com.example.currencyconvertorservice")
@EnableDiscoveryClient
public class CurrencyConvertorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConvertorServiceApplication.class, args);
    }
    
  //adding sleuth to this app for enable distributed tracing
    @Bean    
    public Sampler defaultSampler() {
    	return Sampler.ALWAYS_SAMPLE;
    }
}
