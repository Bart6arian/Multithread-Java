package com.practice.multi.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DbManager implements Runnable {

    private static int counter;
    private static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void connect() throws InterruptedException {
        Random rnd = new Random();
        synchronized (DbManager.class) {
            counter++;
            if(counter == 1) {
                System.out.println("There is " + counter + " connection");
            } else
                System.out.println("There are " + counter + " connections");
        }
        Thread.sleep(rnd.nextInt(100));
        synchronized (DbManager.class) {
            counter--;
        }
    }
}
