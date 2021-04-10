package com.chintan.ds;

public class Fibonacci {

    private static void printFibonacciSeries(int number) {
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 1; i <= number; i++) {
            System.out.print(a + ", ");
            a = b;
            b = c;
            c = a + b;
        }
    }

    private static int printFibonacciSeriesRecursive(int number) {
        if (number <= 1) {
            return number;
        }

        return printFibonacciSeriesRecursive(number - 1) + printFibonacciSeriesRecursive(number - 2);
    }

    public static void main(String[] args) {
        int number = 10;
        printFibonacciSeries(number);
        System.out.println();
        System.out.println(printFibonacciSeriesRecursive(number));
    }
}
