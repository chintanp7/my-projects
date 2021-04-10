package com.chintan.ds;

public class ArrayOddOccurrence {

    private static int getOddTimesElement(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 30, 40, 30, 20, 10};

        System.out.println("Odd element: " + getOddTimesElement(arr));
    }
}
