package com.chintan.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSort {

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(5,6,7,1,2,3,4,15,14,12,11,10);

        List<Integer> sortedNumList = (List<Integer>) numList.stream().sorted(new CustomComparator()).collect(Collectors.toList());

        sortedNumList.forEach(System.out::println);
    }
}

class CustomComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Integer num1 = (Integer) o1;
        Integer num2 = (Integer) o2;

        if (num1 % 2 == 0 && num2 % 2 == 1) {
            return -1;
        }

        if (num1 % 2 == 1 && num2 % 2 == 0) {
            return 1;
        }

        return num1 - num2;
    }
}
