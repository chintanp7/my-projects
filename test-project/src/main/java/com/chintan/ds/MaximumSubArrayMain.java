package com.chintan.ds;

public class MaximumSubArrayMain {

    public int kandaneForMaxSubArray(int[] arr) {
        int maxEndHere = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndHere += arr[i];
            if (maxEndHere < 0) {
                maxEndHere = 0;
            }
            if (maxEndHere > maxSoFar) {
                maxSoFar = maxEndHere;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, -3, -7, 2, 7, -1, 9};
        MaximumSubArrayMain maxSum = new MaximumSubArrayMain();
        System.out.println("Maximum subarray is  " + maxSum.kandaneForMaxSubArray(arr));
    }
}
