package com.practice.multi.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            es.submit(new DbManager());
        }
        es.shutdown();
    }
}
