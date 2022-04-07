package com.practice.multi.multiply;

public class SimpleCalc implements Runnable {

    private int sum;
    private int[] elems;

    public SimpleCalc(int[] elems) {
        this.elems = elems;
    }

    private int multiplyBy3(int[] elems) {
        int value;
        for(int i = 0; i < elems.length; i++) {
            value = elems[i]*3;
            sum += value;
        }
        return sum;
    }

    @Override
    public void run() {
        multiplyBy3(elems);
    }

    public int getSum() {
        return sum;
    }
}
