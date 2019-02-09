package com.ag.data;

import com.ag.config.Constants;
import com.ag.config.ExchangeRatesHolder;
import org.apache.commons.lang.StringUtils;

import java.util.function.Function;

import static com.ag.config.FileConfig.CREDIT_DATA_FILE;

public class CreditData {
    private String companyCode;
    private String account;
    private String city;
    private String country;
    private String creditRating;
    private String currency;
    private Double amount;

    public CreditData(String[] columns) {
        int counter = 0;
        this.companyCode = StringUtils.trimToEmpty(columns[counter++]);
        this.account = StringUtils.trimToEmpty(columns[counter++]);
        this.city = StringUtils.trimToEmpty(columns[counter++]);
        this.country = StringUtils.trimToEmpty(columns[counter++]);
        this.creditRating = StringUtils.trimToEmpty(columns[counter++]);
        this.currency = StringUtils.trimToEmpty(columns[counter++]);
        try {
            this.amount = Double.parseDouble(columns[counter]);
        } catch (NumberFormatException nfe) {
            this.amount = 0.0;

        }
    }


    public String getCompanyCode() {
        return companyCode;
    }

    public String getAccount() {
        return account;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getAmountInEuros() {
        return ExchangeRatesHolder.INSTANCE.convert(this.currency, Constants.EUR, this.amount);
    }

    public static Function<String, CreditData> mapToCreditData = (line) -> {
        String[] row = line.split(CREDIT_DATA_FILE.getDelimiter());// a CSV has comma separated lines
        return new CreditData(row);

    };

    public static Function<CreditData, GroupingKey> groupCreditDataBy = (data) -> {
        String countryCriteria = data.country;
        String creditRatingCriteria = data.creditRating;
        if (StringUtils.isEmpty(data.country)) {
            countryCriteria = data.city;
        }

        return new CreditRatingGroupingKey(countryCriteria, creditRatingCriteria);
    };

}
