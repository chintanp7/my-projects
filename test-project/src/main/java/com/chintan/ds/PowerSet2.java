package com.chintan.ds;

public class PowerSet2 {

    private static void printPowerSet(char[] arr) {
        int counter = (int) Math.pow(2, arr.length);

        for (int i = 0; i < counter; i++) {
            System.out.print("[");
            for (int j = 0; j < arr.length; j++) {
                if ((i & 1 << j) > 0) {
                    System.out.print(arr[j]);
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        printPowerSet(arr);
    }
}
