package com.ag.data;

import com.ag.config.Constants;
import org.apache.commons.lang.StringUtils;

public class ExchangeRate {

    private String fromCurrency ;

    private String toCurrency ;

    private Double rate;


    public ExchangeRate(String[] columns) {

        int counter = 0;
        this.fromCurrency = StringUtils.defaultIfEmpty(StringUtils.trimToEmpty(columns[counter++]), Constants.USD);
        this.toCurrency = StringUtils.defaultIfEmpty(StringUtils.trimToEmpty(columns[counter++]), Constants.USD);

        this.rate = Double.valueOf(StringUtils.defaultIfEmpty(StringUtils.trimToEmpty(columns[counter]), Constants.DEFAULT_RATE));
    }

    public ExchangeRate(){
        this.fromCurrency = Constants.USD;
        this.toCurrency = Constants.USD;
        this.rate = 1.0;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public Double getRate() {
        return rate;
    }
}
