package com.pracitce.multi.barrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CalculationClass implements Runnable {

    private int sumA = 1000;
    private int sumB = 0;

    private final CyclicBarrier barrier;

    public CalculationClass(CyclicBarrier barrier) {
        this.barrier = barrier;
        new Thread(this).start();
    }

    private int calculateSumA() {
        Random r = new Random();
        int i = r.nextInt(9);
        return sumA += i;
    }

    private int calculateSumB() {
        Random r = new Random();
        int i = r.nextInt(49);
        return sumB += i;
    }

    private boolean checkSums() {
        return sumB > sumA;
    }

    @Override
    public void run() {

        while (!checkSums()) {
            calculateSumA();
            calculateSumB();
            System.out.println("Sum A = " + sumA + '\n' + "Sum B = " + sumB);
        }
        System.out.println("Reached end of barrier");
    }
}
