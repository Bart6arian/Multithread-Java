package com.pracitce.multi.latch;

import java.util.concurrent.CountDownLatch;

public class ExampleTask implements Runnable {

    private CountDownLatch latch;

    public ExampleTask(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            doTask();
        }
    }

    private void doTask() {
        System.out.println("Running task");
        latch.countDown();
    }
}
