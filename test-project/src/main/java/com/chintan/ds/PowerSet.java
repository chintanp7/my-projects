package com.chintan.ds;

public class PowerSet {

    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c', 'd'};
        printPowerSet(set);
    }

    private static void printPowerSet(char[] set) {
        int setSize = set.length;
        long powOfSetSize = (long) Math.pow(2, setSize);

        for (int i = 0; i < powOfSetSize; i++) {
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }

    }
}
