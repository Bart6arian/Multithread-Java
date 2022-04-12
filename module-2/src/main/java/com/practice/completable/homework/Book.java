package com.practice.completable.homework;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import static com.pracitce.util.SleepUtil.sleep;

public class Book {

    private String title;
    private String author;
    private LocalDate publicationYear;
    private String signature;

    public Book(String title, String author, LocalDate publicationYear, String signature) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    private void makeSignature(String signature) {
        this.signature = signature;
    }

    public CompletableFuture<String> showBook(String newSignature) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Showing book");
            sleep(2);
            makeSignature(newSignature);
            return "title: " + title + '\n'
                    + "author: " + author +'\n'
                    + "year of publication: " + publicationYear + '\n'
                    + "signature: " + signature;
        });
    }
}
