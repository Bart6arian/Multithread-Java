package com.pracitce.multi.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PartialStep implements Runnable {
    private final CyclicBarrier barrier;
    private final int number;
    public PartialStep(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thead number " + number + " has been launched");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
