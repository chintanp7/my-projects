package com.chintan.ds.sort;

public class QuickSort2 {

    private static int partition(int[] arr, int begin, int end) {
        int pivot = end;
        int counter = begin;

        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;

        return counter;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
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
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
