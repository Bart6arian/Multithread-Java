package com.practice.lock;

import java.util.Random;

import static com.pracitce.util.SleepUtil.sleep;

public class OrderManager implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public OrderManager(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            sleep(3);
            int id = new Random().nextInt(4);

            switch (id) {
                case 1 -> warehouse.remove(Product.BOOK, workerName);
                case 2 -> warehouse.remove(Product.ELECTRONICS, workerName);
                case 3 -> warehouse.remove(Product.TOYS, workerName);
            }
        }
    }
}
