package com.pracitce.multi.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.pracitce.multi.latch.RandomTask.timeGenerator;

public class LatchApp {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);

        new RandomTask(latch);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The latch has been closed");
    }
}
