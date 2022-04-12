package com.practice.completable;

import java.util.concurrent.CompletableFuture;

import static com.pracitce.util.SleepUtil.sleep;

public class MessageReceiver {

    public CompletableFuture<String> receive() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for message");
            sleep(5);
            return "Hello";
        });
    }
}
