package com.chintan.string;

public class Permutation2 {

    private static void doPermutation(String candidate, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(candidate);
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newCandidate = candidate + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            doPermutation(newCandidate, newRemaining);
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        doPermutation("", str);
    }
}
