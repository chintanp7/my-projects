package com.chintan.ds;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = { -8, -3, -7, -2,  -9, -3};
        System.out.println("Maximum sum of subarray is: " + findMaxSubArraySum(arr));
    }

    private static int findMaxSubArraySum(int[] arr) {
        int max = arr[0];
        int tempMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            tempMax = Math.max(arr[i], tempMax + arr[i]);
            /*if (tempMax < 0) {
                tempMax = 0;
            }*/

            if (tempMax > max) {
                max = tempMax;
            }
        }

        return max;
    }
}
