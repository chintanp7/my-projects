package com.chintan.ds;

public class ClosestSum {

    private static void findClosestSumPair(int[] arr, int num) {
        int sum = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tempSum = arr[i] + arr[j] - num;
                if (Math.abs(tempSum) < sum) {
                    num1 = arr[i];
                    num2 = arr[j];
                    sum = Math.abs(tempSum);
                }
            }
        }
        System.out.println("Found pair [" + num1 + ", " + num2 + "] with sum: " + sum);
    }

    public static void main(String[] args) {
        int[] arr = {-40, -5, 1, 3, 6, 7, 8, 20};
        findClosestSumPair(arr, 5);
    }
}
