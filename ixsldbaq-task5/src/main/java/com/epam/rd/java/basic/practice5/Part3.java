package com.epam.rd.java.basic.practice5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


public class Part3 {
    private static final Logger LOG = Logger.getLogger(Part3.class.getName());
    private int numberOfThreads;
    private int numberOfIterations;
    private int counter = 0;
    private int counter2 = 0;
    private Lock lock = new ReentrantLock();

    public Part3(int numberOfThreads, int numberOfIterations) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfIterations = numberOfIterations;
    }


    public static void main(final String[] args) {
        new Part3(2, 5).compare();
        System.out.println("~~~");
        new Part3(2, 5).compareSync();
    }


    public void compare() {
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; ++i) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < numberOfIterations; ++j) {
                        System.out.println("counter:" + counter + " counter2:" + counter2 + " =" + (counter == counter2));
                        counter++;
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            LOG.severe(e.getMessage());
                            Thread.currentThread().interrupt();
                        }
                        counter2++;
                    }
                }
            };
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                LOG.severe(e.getMessage());
                threads[i].interrupt();
            }
        }
    }

    public void compareSync() {
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; ++i) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < numberOfIterations; ++j) {
                        lock.lock();
                        System.out.println("counter:" + counter + " counter2:" + counter2 + " =" + (counter == counter2));
                        counter++;
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            LOG.severe(e.getMessage());
                            Thread.currentThread().interrupt();
                        }
                        counter2++;
                        lock.unlock();
                    }
                }
            };
            threads[i].start();
        }
        for (int i = 0; i < threads.length; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                LOG.severe(e.getMessage());
                threads[i].interrupt();
            }
        }
    }
}