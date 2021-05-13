package com.chintan.ds.sort;

public class MergeSort {

    private static void merge(int[] arr, int low, int mid, int high) {

        // Create sub-arrays
        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];

        // Fill sub-arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        // Put the elements back to main array with sorting
        for (int i = low; i <= high; i++) {

            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                arr[i] = leftArray[leftIndex];
                leftIndex++;

            } else if (rightIndex < rightArray.length) {
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {60, 80, 30, 70, 10, 40, 20, 50};
        print(arr);
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
