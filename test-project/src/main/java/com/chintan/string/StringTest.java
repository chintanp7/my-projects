package com.chintan.string;

import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) {
        String s1 = "Chintan";
        String s2 = new String("Chintan").intern();

        System.out.println(s1 == s2);

        String[] strArr = {"c", "bc", "bad", "abcd"};

        Arrays.asList(strArr).forEach(System.out::println);

        Arrays.sort(strArr);
        System.out.println("====================");

        Arrays.asList(strArr).forEach(System.out::println);

        System.out.println("=====================");

        String str = "abcdefgh";

        String str1 = str.substring(0, 2);
        String str2 = str.substring(3);

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
