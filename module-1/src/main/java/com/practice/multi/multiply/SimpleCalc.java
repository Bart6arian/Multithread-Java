package com.practice.multi.multiply;

public class SimpleCalc implements Runnable {

    private int sum;
    private int[] elems;

    public SimpleCalc(int[] elems) {
        this.elems = elems;
    }

    private int multiplyBy3(int value) {
        sum = value * 3;
        return sum;
    }

    @Override
    public void run() {
        for(int i = 0; i < elems.length; i++) {
            multiplyBy3(elems[i]);
        }
    }

    public int getSum() {
        return sum;
    }
}
