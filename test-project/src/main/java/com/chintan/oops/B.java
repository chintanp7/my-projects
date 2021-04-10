package com.chintan.oops;

public class B extends A implements I, I2 {

    @Override
    void methodA() {
        System.out.println("Inside A method");
    }

    @Override
    public void interfaceMethod() {
        System.out.println("Inside Interface method");
    }

    @Override
    public void defaultMethodI() {
        System.out.println("Inside overridden default method");
    }

    public void methodB() {
        System.out.println("Inside B Class method");
    }

    public static void main(String... args) {
        A a = new B();
        a.methodA();
        a.concreteMethodA();
        a.superInterfaceMethod();
        a.superDefaultMethod();
        ((B) a).methodB();
        ((B) a).interfaceMethod();

        B b = new B();
        b.interfaceMethod();
        b.methodA();
        b.methodB();
        b.concreteMethodA();
        b.defaultMethodI();
        b.superInterfaceMethod();
        b.superDefaultMethod();
        b.superInterface2Method();
        b.i2Method();

        I i = new B();
        i.interfaceMethod();
        i.defaultMethodI();
        i.superInterface2Method();


        SuperI si = new B();
        si.superInterfaceMethod();
        si.superDefaultMethod();

        SuperI2 si2 = new B();
        si2.superInterface2Method();

        I2 i2 = new B();
        i2.i2Method();


    }

    @Override
    public void superInterfaceMethod() {
        System.out.println("Inside Super Interface method");
    }

    @Override
    public void superInterface2Method() {
        System.out.println("Inside super interface 2 method");
    }

    @Override
    public void i2Method() {
        System.out.println("Inside I2 method");
    }
}


abstract class A implements SuperI {
    abstract void methodA();

    void concreteMethodA() {
        System.out.println("Inside Concrete method A");
    }
}

interface I extends SuperI2 {

    void interfaceMethod();

    default void defaultMethodI() {
        System.out.println("Inside default method");
    }
}

interface SuperI {
    void superInterfaceMethod();

    default void superDefaultMethod() {
        System.out.println("Inside super default method");
    }
}

interface SuperI2 {
    void superInterface2Method();
}

interface I2 {
    void i2Method();
}