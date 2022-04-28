package com.practice.threads;

public class ThreadCreator extends Thread {

    private final int num;

    public ThreadCreator(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        Runnable runnable = () -> new Thread(String.valueOf(num + 1));
        if (num != 50) {
            System.out.println("Hello from Thread number " + num);
            runnable.run();
        }
    }
}
