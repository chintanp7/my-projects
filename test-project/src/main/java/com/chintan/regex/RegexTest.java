package com.chintan.regex;

import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        String subsite = "(https:\\/\\/www.pornxbit.com\\/(?!porn-videos\\/)\\w+)(-\\w+)+\\/";
        String url = "https://www.pornxbit.com/puretaboo-2021-01-26-maya-woulfe-ungrateful/";

        System.out.println(Pattern.compile(subsite)
                .matcher(url)
                .matches());
    }
}
