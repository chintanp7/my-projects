package com.chintan.oops;

public class PassByValue {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Max");
        Dog dog2 = dog1;

        foo(dog1);

        System.out.println(dog1.getName());
        System.out.println(dog2.getName());
        System.out.println(dog1 == dog2);

        int a = 5;
        fii(a);
        System.out.println(a);

        int b = 10;
        int c = b;
        c = 15;

        System.out.println(b);
        System.out.println(c);
    }

    static void foo(Dog d) {
        //d = new Dog("Fifi");
        Dog d1 = new Dog("Chichi");
        d = d1;

        //d.setName("Fafa");
        System.out.println(d.getName());
    }

    static void fii(int i) {
        i = 10;
    }
}

class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}