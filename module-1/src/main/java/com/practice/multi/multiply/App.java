package com.practice.multi.multiply;

import com.practice.multi.executor.Task;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {

        /*int[] theArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        SimpleCalc calc = new SimpleCalc(theArray);
        calc.run();
        int sum = calc.getSum();
        System.out.println("Sum of first calc = " + sum);*/
        // task 1.2


        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        int[] theArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] theArray2 = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        SimpleCalc2 calc = new SimpleCalc2(theArray, theArray2);

        for (int n = 0; n < cores; n++) {
            calc.run();
        }
        System.out.println(Arrays.toString(calc.getScores()));

        executorService.shutdown();
    }
}
