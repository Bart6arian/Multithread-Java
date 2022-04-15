package com.pracitce.multi.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class BookExchanger implements Runnable {
    private Exchanger<String> exchanger;

    public BookExchanger(Exchanger<String> exchanger) {
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
