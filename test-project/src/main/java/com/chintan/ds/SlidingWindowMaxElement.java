package com.chintan.ds;

import java.util.LinkedList;

public class SlidingWindowMaxElement {

    public static void main(String[] args) {
        int[] arr = {2, 6, -1, 2, 4, 1, -6, 5};
        int windowSize = 3;

        solve(arr, windowSize);
    }

    private static void solve(int[] arr, int windowSize) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            while (!list.isEmpty() && arr[list.getLast()] <= arr[i]) {
                list.removeLast();
            }

            while ((!list.isEmpty() && list.getFirst() <= i - windowSize)) {
                list.removeFirst();
            }

            list.addLast(i);

            if (i >= windowSize - 1) {
                System.out.print(" " + arr[list.getFirst()]);
            }
        }
    }
}
