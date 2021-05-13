package com.chintan.collections;

import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map<Student, Integer> map = new HashMap<>();
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("S1");
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("S2");
        map.put(s1, 1);
        map.put(s2, 2);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(map.size());

        Map<String, String> stringMap = new ConcurrentHashMap<>();
        stringMap.put("abc", null);
    }

}

class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return this.getId() == other.getId() && StringUtils.equals(this.getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }
}