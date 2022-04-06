package com.practice.multi.simple;

public class Application {

    public static void main(String[] args) {
        Thread t0 = new Thread(new CounterRunnable());
        Thread t1 = new Thread(new CounterRunnable());
        t0.start();
        t1.run();
    }
}
