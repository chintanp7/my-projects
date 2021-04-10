package com.chintan.thread;

public class DeadlockSample {

    Object a = new Object();
    Object b = new Object();

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting T1");
            synchronized (a) {
                System.out.println("Acquired A: " + t1.getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("Acquired Both: " + t1.getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Released A: " + t1.getName());
            }

            System.out.println("Released Both: " + t1.getName());
            System.out.println("Completed T1");
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting T2");
            synchronized (b) {
                System.out.println("Acquired B: " + t2.getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("Acquired Both: " + t2.getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Released B: " + t2.getName());
            }

            System.out.println("Released Both: " + t2.getName());
            System.out.println("Completed T2");
        }
    });

    public static void main(String[] args) {
        DeadlockSample ds = new DeadlockSample();
        ds.t1.start();
        ds.t2.start();
    }
}
