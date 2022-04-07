package com.practice.multi.multiply;

public class App {

    public static void main(String[] args) {
        int[] theArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        SimpleCalc calc = new SimpleCalc(theArray);
        calc.run();
        int sum = calc.getSum();
        System.out.println("Sum of first calc = " + sum);
    }
}
