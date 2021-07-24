package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class Part4 {
    private static final Logger LOG = Logger.getLogger(Part4.class.getName());
    private static String[][] arr;
    private static int[] masint;
    private static CountDownLatch countDownLatch;

    public static void main(final String[] args) {

        String fileName = "part4.txt";
        arr = readFileAndCreatMatrix(fileName);
        countDownLatch = new CountDownLatch(arr.length);
        masint = new int[arr.length];

        long startSync = System.currentTimeMillis();

        Thread[] threads = new Thread[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            threads[i] = new FindMax(i);
            threads[i].start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            LOG.severe(e.getMessage());
            Thread.currentThread().interrupt();
        }
        int maxValueSync = 0;
        for (int i = 0; i < masint.length; ++i) {
            if (masint[i] > maxValueSync) {
                maxValueSync = masint[i];
            }
        }

        long endSync = System.currentTimeMillis();

        System.out.println(maxValueSync);
        System.out.println(endSync - startSync);

        int maxValue = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    LOG.severe(e.getMessage());
                    Thread.currentThread().interrupt();
                }
                if (Integer.parseInt(arr[i][j]) > maxValue) {
                    maxValue = Integer.parseInt(arr[i][j]);
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(maxValue);
        System.out.println(end - start);

    }

    private static String[][] readFileAndCreatMatrix(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine())
                sb.append(scanner.nextLine()).append(System.lineSeparator());
        } catch (FileNotFoundException e) {
            LOG.severe(e.getMessage());
        }
        String[] mas = sb.toString().split(System.lineSeparator());
        String[][] array = new String[mas.length][];
        for (int i = 0; i < mas.length; ++i) {
            array[i] = mas[i].split(" ");
        }
        return array;
    }


    private static class FindMax extends Thread {
        private final int index;

        FindMax(int index) {
            this.index = index;
        }

        private static void addTomasint(int index,int value){
            masint[index]=value;
        }
        @Override
        public void run() {
            int maxValue = 0;
            for (int j = 0; j < arr[index].length; ++j) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    LOG.severe(e.getMessage());
                    Thread.currentThread().interrupt();
                }
                if (Integer.parseInt(arr[index][j]) > maxValue) {
                    maxValue = Integer.parseInt(arr[index][j]);
                }
            }
            addTomasint(index,maxValue);
            countDownLatch.countDown();
        }
    }
}
