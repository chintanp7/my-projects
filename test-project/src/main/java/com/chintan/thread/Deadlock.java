package com.chintan.thread;

public class Deadlock {

    public static void main(String[] args) {

        Test test = new Test();
        Thread t1 = new Thread(new Thread1(test));
        Thread t2 = new Thread(new Thread2(test));

        for (int i = 1; i < 10; i++) {
            new Thread(new Thread1(test)).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Thread2(test)).start();
        }
    }
}

class Test {
    Object a = new Object();
    Object b = new Object();

    void method1() {
        synchronized (a) {
            System.out.println("Method 1 start: " + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Method 1 end: " + System.currentTimeMillis());
        }
    }

    void method2() {
        synchronized (b) {
            System.out.println("Method 2 start: " + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Method 2 end: " + System.currentTimeMillis());
        }
    }
}

class Thread1 implements Runnable {

    Test t;

    Thread1(Test t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("Inside Thread 1");
        t.method1();
        t.method2();
    }
}


class Thread2 implements Runnable {

    Test t;

    Thread2(Test t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("Inside Thread 2");
        t.method2();
        t.method1();
    }
}