package com.pracitce.multi.parallel.populationCounter;

import java.util.concurrent.RecursiveTask;

public class CountryProcessTask extends RecursiveTask<Long> {

    private Countries countries;

    public CountryProcessTask(Countries countries) {
        this.countries = countries;
    }

    @Override
    protected Long compute() {
        return countries.showCountries()
                .parallelStream()
                .mapToLong(CountryProcessTask::calculatePeople)
                .sum();
    }

    private static long calculatePeople(Country country) {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return country.getPeopleNumber();
    }
}
