package com.pracitce.multi.parallel;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Book> books = Books.randomBooks(1000);

        long begin = System.nanoTime();
        long sum = books
                .stream()
                .mapToLong(Application::processData)
                .sum();
        long end = System.nanoTime();

        System.out.println("Processing 1k books with stream() has taken " + (end-begin) + " ns.");
        System.out.println("The sum is equal to " + sum);

        begin = System.nanoTime();
        sum = books
                .parallelStream()
                .mapToLong(Application::processData)
                .sum();
        end = System.nanoTime();

        System.out.println("Processing 1k books with parallelStream() has taken " + (end-begin) + " ns.");
        System.out.println("The sum is equal to " + sum);
    }

    private static long processData(Book book) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (long) (book.getYear() * 2 + book.getYear() / 2 + Math.floor(Math.sqrt(book.getYear())));
    }
}
