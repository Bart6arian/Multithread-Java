package com.pracitce.multi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerProducer implements Runnable {

    private Exchanger<String> exchanger;

    public ExchangerProducer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                exchanger.exchange("Message number ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
