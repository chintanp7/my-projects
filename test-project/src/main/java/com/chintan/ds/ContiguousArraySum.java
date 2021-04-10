package com.chintan.ds;

public class ContiguousArraySum {

    private static void findContiguousArray(int[] arr, int sum) {
        int i = 0, j = 0;
        int currentSum = 0;

        while(i < arr.length && j < arr.length) {

            if (currentSum == sum) {
                System.out.println("Start index: " + i + ", End index: " + j);
                break;
            }

            if (currentSum < sum) {
                currentSum += arr[j];
                j++;
            } else {
                currentSum -= arr[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {14, 12, 70, 15, 99, 65, 21, 90};
        findContiguousArray(arr, 97);
    }
}
