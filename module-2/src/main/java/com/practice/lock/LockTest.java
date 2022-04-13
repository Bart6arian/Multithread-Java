package com.practice.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockTest {

    public static void main(String[] args) {
        final LockedWarehouse warehouse = new LockedWarehouse();

        final ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Worker("Worker 1", warehouse));
        service.submit(new Worker("Worker 2", warehouse));
        service.submit(new Worker("Worker 3", warehouse));
        service.submit(new InventoryWorker("Inventory 1", warehouse));
        service.submit(new InventoryWorker("Inventory 2", warehouse));
        service.submit(new OrderManager("Manager 1", warehouse));
        service.submit(new OrderManager("Manager 2", warehouse));

        service.shutdown();
    }
}
