package com.practice.multi.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);

        for (int n = 0; n < 1000; n++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }

}
