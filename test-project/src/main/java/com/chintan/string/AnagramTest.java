package com.chintan.string;

public class AnagramTest {

    public static void main(String[] args) {
        String word = "java2blog";
        String anagram = "aj2vabgol";

        System.out.println("Anagram: " + isAnagram(word, anagram));
    }

    private static boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            int index = anagram.indexOf(c);

            if (index == -1) {
                return false;
            }

            anagram = anagram.substring(0, index) + anagram.substring(index + 1);
        }

        return anagram.isEmpty();
    }
}
