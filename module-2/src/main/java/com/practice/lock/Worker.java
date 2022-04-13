package com.practice.lock;

import java.util.Random;

import static com.pracitce.util.SleepUtil.sleep;

public class Worker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public Worker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            sleep(1);
            final Random r = new Random();
            int id = r.nextInt(3);

            if (id == 0) {
                warehouse.add(Product.BOOK, workerName);
            } else if (id == 1) {
                warehouse.add(Product.ELECTRONICS, workerName);
            } else {
                warehouse.add(Product.TOYS, workerName);
            }

            /*switch (id) { switch is better to show multithreading IMO
                case 1 : warehouse.add(Product.BOOK, workerName);
                break;
                case 2 : warehouse.add(Product.ELECTRONICS, workerName);
                break;
                case 3 : warehouse.add(Product.TOYS, workerName);
            }
*/        }
    }
}
