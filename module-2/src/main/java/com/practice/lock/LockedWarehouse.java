package com.practice.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

import static com.pracitce.util.SleepUtil.sleep;

public class LockedWarehouse {

    private final Map<Product, Integer> products = new HashMap<>();
    private final StampedLock lock = new StampedLock();

    public void add(Product product, String by) {
        System.out.println("I'm " + by + " and want to add " + product);
        long stamp = lock.writeLock();
        try {
            sleep(2);
            products.merge(product, 1, Integer::sum);
            System.out.println("Product " + product + " added by " + by + ". Now is " + countProducts());
        } finally {
            lock.unlock(stamp);
        }
    }

    public void remove(Product product, String worker) {
        System.out.println("Worker " + worker + " wants to delete product [" + product + "]");
        long l = lock.writeLock();
        try {
            sleep(3);
            products.remove(product);
            System.out.println("Worker " + worker + " removed " + product + " from warehouse");
        } finally {
            lock.unlock(l);
        }
    }

    private int countProducts() {
        return products.values().stream()
                .reduce(0, Integer::sum);
    }

    public void showProducts(String inventoryWorkerName) {
        System.out.println("I'm " + inventoryWorkerName + " and want to check INVENTORY");
        long stamp = lock.readLock();
        try {
            products.forEach((key, value) ->
                    System.out.println("[" + inventoryWorkerName +"] " + "Product: " +key + " quantity: " + value));
        } finally {
            lock.unlock(stamp);
        }
    }
}
