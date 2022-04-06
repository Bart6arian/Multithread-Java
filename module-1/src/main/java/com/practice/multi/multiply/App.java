package com.practice.multi.multiply;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        int[] theArray = new int[9];
        int[] theArray2 = new int[9];

        Random random = new Random();
        int i = random.nextInt(30);
        int i1 = random.nextInt(92)+16;

        for (int n = 0; n < theArray.length; n++) {
            theArray[n] = i;
        }

        for (int n = 0; n < theArray2.length; n++) {
            theArray2[n] = i1;
        }

        SimpleCalc calc = new SimpleCalc(theArray);
        SimpleCalc calc2 = new SimpleCalc(theArray2);
        calc.run();
        calc2.run();
        int sum = calc.getSum();
        int sum2 = calc2.getSum();
        System.out.println("Sum of first calc = " + sum +'\n'
                +"Sum of second calc = " + sum2);
    }
}
