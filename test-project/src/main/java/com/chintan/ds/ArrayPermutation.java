package com.chintan.ds;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        doPermutation(new ArrayList<>(), list);
    }

    private static void doPermutation(List<Integer> candidate, List<Integer> remaining) {
        if (remaining.size() == 0) {
            System.out.println(candidate.toString());
        }

        for (int i = 0; i < remaining.size(); i++) {
            List<Integer> newCandidate = new ArrayList<>(candidate);
            List<Integer> newRemaining = new ArrayList<>();
            newCandidate.add(remaining.get(i));
            addElements(newRemaining, remaining, i);
            doPermutation(newCandidate, newRemaining);
        }

    }

    private static void addElements(List<Integer> newList, List<Integer> sourceList, int skipIndex) {
        for(int i = 0; i < sourceList.size(); i ++) {
            if (i == skipIndex) {
                continue;
            }
            newList.add(sourceList.get(i));
        }
    }
}
