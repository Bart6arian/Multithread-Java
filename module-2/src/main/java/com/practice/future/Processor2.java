package com.practice.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.pracitce.util.SleepUtil.sleep;

public class Processor2 {

    public Future<Double> process(double w) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Processor 2 start doing something");
            sleep(3);
            System.out.println("Processor 2 finished its task");
            return w * 3000;
        });
    }
}
