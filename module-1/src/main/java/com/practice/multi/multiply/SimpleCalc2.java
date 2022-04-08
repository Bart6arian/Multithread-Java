package com.practice.multi.multiply;

import java.util.Arrays;

public class SimpleCalc2 implements Runnable {

    private int[] elems;
    private int[] elems2;
    private long[] scores;

    public SimpleCalc2(int[] elems, int[] elems2) {
        this.elems = elems;
        this.elems2 = elems2;
    }

    private void executeMath() {
        multiplyByValueOfOtherArray(elems, elems2);
    }

    private void multiplyByValueOfOtherArray(int[] elems, int[] elems2) {

        long[] tempResult = new long[elems.length];
        for (int i = 0; i < elems.length; i++) {
            tempResult[i] = (long) elems[i] * elems2[i];
        }
        scores = tempResult;
    }

    public long[] getScores() {
        return scores;
    }

    @Override
    public void run() {
        executeMath();
        System.out.println(Arrays.toString(getScores()));
    }
}
