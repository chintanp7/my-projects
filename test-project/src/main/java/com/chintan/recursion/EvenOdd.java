package com.chintan.recursion;

public class EvenOdd {

    private static void checkEvenOdd(int num) {

        if (num == 0) {
            return;
        }

        checkEvenOdd(num - 1);
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
    }

    public static void main(String[] args) {
        checkEvenOdd(10);
    }
}
