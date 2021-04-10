package com.chintan.collections;

import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        Set<Student1> student1Set = new TreeSet<>();
        Student1 s1 = new Student1();
        s1.setId(1);
        s1.setName("S1");
        Student1 s2 = new Student1();
        s2.setId(2);
        s2.setName("S2");
        student1Set.add(s1);
        student1Set.add(s2);
        student1Set.forEach(System.out::println);
    }
}

class Student1 {
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
        Student1 other = (Student1) obj;
        return this.getId() == other.getId() && StringUtils.equals(this.getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}