package com.chintan.oops;

import com.sun.org.apache.xpath.internal.axes.ChildTestIterator;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        String firstName = "Chintan";
        String lastName = "Patel";

        char[] firstNameArr = firstName.toCharArray();
        char[] lastNameArr = lastName.toCharArray();

        char[] newArr = ArrayUtils.addAll(firstNameArr, lastNameArr);

        Arrays.sort(newArr);

        System.out.println(newArr);

        List<? extends Parent> list = new ArrayList<Child>();
        Parent child1 = new Child();


        for(Object c : list) {

        }

        System.out.println(2.00 - 1.10);

        Parent parent = new Parent();
        child1.hello();
        parent.hello();

        Child child = new Child();
        child.hello();
    }
}


class Parent {
    public void print() {
        System.out.println("From parent");
    }

    public static void hello() {
        System.out.println("Hello");
    }
}

class Child extends Parent {
    @Override
    public void print() {
        System.out.println("From Child");
    }

   /* public static void hello() {
        System.out.println("Hello 2");
    }*/
}