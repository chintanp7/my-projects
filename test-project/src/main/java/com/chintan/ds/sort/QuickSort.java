package com.chintan.ds.sort;

public class QuickSort {

    private static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    private static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void doQuickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        doQuickSort(array, begin, pivot-1);
        doQuickSort(array, pivot+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {60, 80, 30, 70, 10, 40, 20, 50};
        int[] good = {10, 20, 30, 40, 50, 60, 70, 80};
        int[] bad = {80, 70, 60, 50, 40, 30, 20, 10};
        int n = arr.length;
        print(arr);
        /*long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            doQuickSort(arr, 0, n-1);
        }
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            doQuickSort(good, 0, n-1);
        }
        long end2 = System.currentTimeMillis();
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            doQuickSort(bad, 0 , n-1);
        }
        long end3 = System.currentTimeMillis();
        System.out.println();
        print(arr);
        System.out.println("Normal case time: " + (end1 - start1));
        print(good);
        System.out.println("Good case time: " + (end2 - start2));
        print(bad);
        System.out.println("Bad case time: " + (end3 - start3));*/
        doQuickSort(arr, 0, n-1);
        System.out.println();
        print(arr);
    }
}
