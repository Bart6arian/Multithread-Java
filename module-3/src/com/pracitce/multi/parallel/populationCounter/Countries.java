package com.pracitce.multi.parallel.populationCounter;

import java.util.ArrayList;
import java.util.List;

public class Countries {

    private List<Country> countries = new ArrayList<>();

    public Countries() {
    }

    private void fillCountries() {
        Country country = new Country("China", 1402000000L, "CNY", "Mandarin");
        Country country1 = new Country("Vietnam", 97340000L, "VND", "Vietnamese");
        Country country2 = new Country("Canada", 38010000L, "CAD", "English");
        Country country3 = new Country("Venezuela", 28440000L, "VED", "Spanish");
        Country country4 = new Country("South Africa", 301440000L, "ZAR", "Zulu");
        Country country5 = new Country("Sweden", 10350000L, "SEK", "Swedish");

        countries.add(country);
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);

    }

    public List<Country> showCountries() {
        fillCountries();
        return countries;
    }
}
