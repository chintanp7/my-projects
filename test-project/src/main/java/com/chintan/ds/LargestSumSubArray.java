package com.chintan.ds;

public class LargestSumSubArray {

    private static void findLargestSumSubArray(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = Math.max(result[i - 1] + arr[i], arr[i]);
        }
        int maxSum = result[0];
        for (int i = 1; i < result.length; i++) {
            if (maxSum < result[i]) {
                maxSum = result[i];
            }
        }
        System.out.println("The max sum from subarray is: " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4, 4, -2};
        findLargestSumSubArray(arr);
    }
}
