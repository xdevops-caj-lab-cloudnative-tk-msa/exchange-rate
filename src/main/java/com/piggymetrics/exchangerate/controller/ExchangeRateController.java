package com.piggymetrics.exchangerate.controller;

import com.piggymetrics.exchangerate.domain.Currency;
import com.piggymetrics.exchangerate.domain.ExchangeRatesContainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/exchangerates")
public class ExchangeRateController {

    private final static Map<String, Map<String, BigDecimal>> allRates;

    static  {
        allRates = new HashMap<>();

        // USD
        Map<String, BigDecimal> usdRates = new HashMap<>();
        usdRates.put("EUR", BigDecimal.valueOf(0.91992185));
        usdRates.put("RUB", BigDecimal.valueOf(77.525177));
        allRates.put("USD", usdRates);

        // EUR
        Map<String, BigDecimal> eurRates = new HashMap<>();
        eurRates.put("USD", BigDecimal.valueOf(1.0870489));
        eurRates.put("RUB", BigDecimal.valueOf(84.273655));
        allRates.put("EUR", eurRates);

        // RUB
        Map<String, BigDecimal> rubRates = new HashMap<>();
        rubRates.put("USD", BigDecimal.valueOf(0.012899035));
        rubRates.put("EUR", BigDecimal.valueOf(0.011866105));
        allRates.put("RUB", rubRates);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/latest")
    ExchangeRatesContainer getRates(@RequestParam("base") Currency base) {
        return ExchangeRatesContainer.builder()
                .base(base)
                .rates(allRates.get(base.name()))
                .build();
    }
}
