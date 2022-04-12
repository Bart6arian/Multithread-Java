package com.practice.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.pracitce.util.SleepUtil.sleep;

public class Processor {

    public Future<Integer> process(int x) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        return service.submit(() -> {
            System.out.println("Processor started processing");
            sleep(5);
            System.out.println("Processor ended processing");
            return x * 1000;
        });
    }
}
