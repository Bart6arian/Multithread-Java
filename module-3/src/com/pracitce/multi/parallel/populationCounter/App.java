package com.pracitce.multi.parallel.populationCounter;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args) {

        Countries countries = new Countries();

        ForkJoinPool pool = new ForkJoinPool();

        Long count = pool.invoke(new CountryProcessTask(countries));

        System.out.println(count);
    }
}
