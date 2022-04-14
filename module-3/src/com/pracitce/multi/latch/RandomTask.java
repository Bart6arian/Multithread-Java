package com.pracitce.multi.latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RandomTask implements Runnable {

    private CountDownLatch latch;

    public RandomTask(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    public static int timeGenerator() {
        Random r = new Random();
        int min = 500;
        int max = 2000;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    private void doStuff() throws InterruptedException {
        int i = timeGenerator();
        System.out.println("Doing something... Operation took: " + i + "ns");
        latch.await(i, TimeUnit.MILLISECONDS);
        latch.countDown();

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                doStuff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
