package com.pracitce.multi.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Book implements Runnable {
    private Exchanger<String> exchanger;

    public Book(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int position = r.nextInt(1000)+300;
            try {
                exchanger.exchange("Title number: " + position + " author number: " + position);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
