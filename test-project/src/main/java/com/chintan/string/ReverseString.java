package com.chintan.string;

public class ReverseString {

    private static String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }

        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String str = "abcdefg";

        System.out.print(reverse(str));
    }
}
