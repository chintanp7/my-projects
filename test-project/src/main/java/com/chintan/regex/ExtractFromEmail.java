package com.chintan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFromEmail {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("([a-zA-Z]+)[^a-zA-Z@]*(@.*)?");
        String input="dmca@mydirtyhobby.com";
        Matcher matcher = p.matcher(input);
        System.out.println(input.substring(input.indexOf('@') + 1, input.lastIndexOf('.')));
    }
}
