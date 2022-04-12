package com.practice.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.pracitce.util.SleepUtil.sleep;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final MessageReceiver messageReceiver = new MessageReceiver();
        final CompletableFuture<Void> futureMessage = messageReceiver.receive()
                .thenApply(String::toUpperCase)
                .thenApply(e -> {
                    throw new RuntimeException("Cannot process message");
                })
                .exceptionally(ex -> {
                    System.err.println("Exception occurred: " + ex.getMessage());
                    return "ERROR";
                })
                .thenAccept(message -> System.out.println("Message is " + message));

        sleep(1);
        System.out.println("Doing something else");

        futureMessage.get();
    }
}
