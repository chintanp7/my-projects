package com.chintan.ds;

public class FindSubArrayWithGivenSum {

    private static void findSubArray(int[] arr, int target) {
        int i = 0, j = 0;
        int currentSum = 0;
        while (i < arr.length && j <= arr.length) {
            if (currentSum == target) {
                System.out.println("Starting index: " + i + ", Ending index: " + j);
                if (j < arr.length) {
                    currentSum += arr[j];
                }
                j++;
            } else {
                if (currentSum > target) {
                    currentSum -= arr[i];
                    i++;
                } else {
                    if (j < arr.length) {
                        currentSum += arr[j];
                    }
                    j++;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 9, 0, 11};
        findSubArray(arr, 9);
    }
}
