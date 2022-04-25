package com.pracitce.multi.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierApp {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());
        PartialStep partialStep = new PartialStep(barrier, 5);

        launchTheThread(partialStep);
    }

        private static void launchTheThread(PartialStep partialStep) {
            new CalculationClass(partialStep);
        }
}
