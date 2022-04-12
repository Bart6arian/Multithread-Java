package com.practice.completable.homework;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.pracitce.util.SleepUtil.sleep;

public class LibraryFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        Book book = new Book("The Old Man And The Sea", "Ernest Hemingway", LocalDate.of(1951, 4, 12), "old signature");
        Book book1 = new Book("Moby Dick", "Herman Melville", LocalDate.of(1851, 10, 18), "old signature");
        CompletableFuture<String> future = book.showBook("new signature");
        CompletableFuture<String> future1 = book1.showBook("new one");

        sleep(3);

        String s = future.get();
        String s1 = future1.get();
        System.out.println("Book 1: " + s + '\n' + "Book 2: " + s1);
    }
}
