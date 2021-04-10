package com.chintan.ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListPermute {

    public static void main(String[] args) {
        permute(Arrays.asList(1, 2, 3, 4), 0);
    }

    private static void permute(List<Integer> list, int k) {
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list, i, k);
            permute(list, k + 1);
            Collections.swap(list, k, i);
        }
        if (k == list.size() - 1) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
