package com.practice.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.pracitce.util.SleepUtil.sleep;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final Processor processor = new Processor();
        final Future<Integer> future = processor.process(5);
        final Processor2 processor2 = new Processor2();
        final Future<Double> future1 = processor2.process(3.2);

        while (!future.isDone() && !future1.isDone()) {
            System.out.println("Doing");
            sleep(1);
        }

        final Integer result = future.get();
        final Double aDoubleResult = future1.get();
        System.out.println("Result of processor 1: " + result + '\n'
                +"Result of processor 2: " + aDoubleResult);
    }
}
