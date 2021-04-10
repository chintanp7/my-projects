package com.chintan.ds;

public class SeparateOddEven {

    private static int[] separate(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            while(arr[i] % 2 == 0) {
                i++;
            }
            while (arr[j] % 2 != 0) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {12, 17, 70, 15, 22, 65, 21, 90};
        for(int i : arr) {
            System.out.print(i + " ");
        }
        arr = separate(arr);
        System.out.println();

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
