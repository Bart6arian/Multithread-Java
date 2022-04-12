package com.practice.multi.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            executorService.submit(new ProcessA());
            executorService.submit(new ProcessB());
        }
    }
}
