package com.chintan.string;

public class Permutation {

    static int count = 1;

    private static void doPermutation(String candidate, String remaining) throws InterruptedException {
        if (remaining.length() == 0) {
            System.out.println(count + ": " + candidate);
            count++;
        }

       // Thread.sleep(5000);

        for (int i = 0; i < remaining.length(); i++) {
            String newCandidate = candidate + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            doPermutation(newCandidate, newRemaining);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String s = "abcd";
        doPermutation("", s);
    }

}

