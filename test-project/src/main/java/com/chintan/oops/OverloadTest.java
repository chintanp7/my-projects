package com.chintan.oops;

public class OverloadTest {

    public static void main(String[] args) {
        // method1(5, 6);

    }

    private static void method1(double d, int i) {
        System.out.println("calling from (double d, int i)");
    }

    private static void method1(int i, double d) {
        System.out.println("calling from (int i, double d)");
    }

    private static void method1( String s1, String s2) {
        System.out.println("calling from ( String s1, String s2)");
    }

    private static void method1(long l, int i) {
        System.out.println("calling from (double d, int i)");
    }

    private static void method1(int i, long l) {
        System.out.println("calling from (int i, double d)");
    }
}
