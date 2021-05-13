package com.chintan.thread;

public class ThreadTest {

    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
        t.start();
        t.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Inside thread");
    }
}