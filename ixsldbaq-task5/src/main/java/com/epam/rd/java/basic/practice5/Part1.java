package com.epam.rd.java.basic.practice5;

import java.util.logging.Logger;

public class Part1 {
    private static final Logger LOG = Logger.getLogger(Part1.class.getName());

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        Thread t2 = new Thread(new MyThread1());
        try {
            t1.join();
        } catch (InterruptedException e) {
            LOG.severe(e.getMessage());
            t1.interrupt();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            LOG.severe(e.getMessage());
            t2.interrupt();
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 4; ++i) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    LOG.severe(e.getMessage());
                    Thread.currentThread().interrupt();
                }

            }
        }
    }

    static class MyThread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; ++i) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    LOG.severe(e.getMessage());
                    Thread.currentThread().interrupt();
                }

            }
        }
    }
}
