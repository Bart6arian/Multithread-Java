package com.pracitce.multi.parallel.populationCounter;

import java.math.BigDecimal;

public final class Country {

    private final String countryName;
    private final Long peopleNumber;
    private final String currency;
    private final String language;

    public Country(String countryName, Long peopleNumber, String currency, String language) {
        this.countryName = countryName;
        this.peopleNumber = peopleNumber;
        this.currency = currency;
        this.language = language;
    }

    public String getCountryName() {
        return countryName;
    }

    public Long getPeopleNumber() {
        return peopleNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLanguage() {
        return language;
    }
}
