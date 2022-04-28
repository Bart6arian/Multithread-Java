package com.practice.threads.com.practice.threads.homework;

import com.practice.threads.ThreadCreator;

public class App {

    public static void main(String[] args) {
        final ThreadCreator creator = new ThreadCreator(1);
        creator.run();
    }
}
