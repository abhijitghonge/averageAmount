package com.ag.data;

public class CreditRatingGroupingKey implements GroupingKey {

    private String countryCriteria ;
    private String creditRatingCriteria;

    public CreditRatingGroupingKey(String countryCriteria, String creditRatingCriteria) {
        this.countryCriteria = countryCriteria;
        this.creditRatingCriteria = creditRatingCriteria;
    }

    public String getCountryCriteria() {
        return countryCriteria;
    }

    public String getCreditRatingCriteria() {
        return creditRatingCriteria;
    }
}
