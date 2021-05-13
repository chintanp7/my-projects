package com.chintan.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModification {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, arr);

        for (int element : list1) {
            element++;
        }

        ListIterator<Integer> itr = list1.listIterator();

        while(itr.hasNext()) {
            Integer element = itr.next();
            if (element == 4) {
                itr.remove();
            }
            if (element == 5) {
                itr.add(8);
            }
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");

        System.out.println(list1);

        List<Integer> list2 = new CopyOnWriteArrayList<>();
        list2.add(1);
        list2.add(null);
    }
}
