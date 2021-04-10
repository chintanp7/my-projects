package com.chintan.ds;

import java.util.Arrays;
import java.util.List;

public class RemoveArrayDuplicates {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 6};

        int n = removeDuplicates(arr, arr.length);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = list.parallelStream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static int removeDuplicates(int arr[], int n) {
        if ( n == 0 ||  n == 1 ) {
            return n;
        }

        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i+1]) {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[n-1];

        return j;
    }
}
