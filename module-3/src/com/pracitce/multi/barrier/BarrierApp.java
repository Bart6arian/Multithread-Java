package com.pracitce.multi.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierApp {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        launchTheThread(barrier);
    }

        private static void launchTheThread(CyclicBarrier barrier) {
            new CalculationClass(barrier);
        }
}
