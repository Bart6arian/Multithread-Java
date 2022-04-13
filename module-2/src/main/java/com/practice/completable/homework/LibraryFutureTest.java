package com.practice.completable.homework;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.pracitce.util.SleepUtil.sleep;

public class LibraryFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Book book = new Book("The Old Man And The Sea", "Ernest Hemingway", LocalDate.of(1951, 4, 12), "old signature");
        Book book1 = new Book("Moby Dick", "Herman Melville", LocalDate.of(1851, 10, 18), "old signature");

        CompletableFuture<String> futureTest = CompletableFuture.supplyAsync(() -> {
            System.out.println("Finding books");
            sleep(3);
            CompletableFuture<String> future = book.showBook("new signature");
            CompletableFuture<String> future1 = book1.showBook("new one");
            try {
                sleep(2);
                return future.get().toLowerCase() +'\n'+ future1.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        String s2 = futureTest.get();
        System.out.println("Books: " + s2);
    }
}
