package com.chintan.ds.sort;

public class SelectionSort {

    private static void doSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {60, 80, 30, 50, 10, 40, 20, 70};
        int[] good = {10, 20, 30, 40, 50, 60, 70, 80};
        int[] bad = {80, 70, 60, 50, 40, 30, 20, 10};
        print(arr);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            doSelectionSort(arr);
        }
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            doSelectionSort(good);
        }
        long end2 = System.currentTimeMillis();
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            doSelectionSort(bad);
        }
        long end3 = System.currentTimeMillis();
        System.out.println();
        print(arr);
        System.out.println("Normal case time: " + (end1 - start1));
        print(good);
        System.out.println("Good case time: " + (end2 - start2));
        print(bad);
        System.out.println("Bad case time: " + (end3 - start3));
    }
}
