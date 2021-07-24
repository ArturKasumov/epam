package com.epam.rd.java.basic.practice5;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class Part5 {
    private static final Logger LOG = Logger.getLogger(Part5.class.getName());
    private static RandomAccessFile file;
    private static CountDownLatch countDownLatch;



    public static void main(final String[] args) {
        countDownLatch = new CountDownLatch(10);
        try {
            file = new RandomAccessFile("part5.txt", "rw");
            for (int i = 0; i < 10; ++i) {
                Thread.sleep(1);
                NumberWriter thread = new NumberWriter(i);
                thread.start();
            }
            countDownLatch.await();
            file.seek(0);
            String i;
            while ((i = file.readLine()) != null) {
                System.out.println(i);
            }
            file.close();
        } catch (IOException | InterruptedException exception) {
            LOG.severe(exception.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static class NumberWriter extends Thread {
        private final int number;

        public NumberWriter( int number) {
            this.number = number;

        }

        private static String creatString(int number) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                sb.append(number);
            }
            sb.append(System.lineSeparator());
            return sb.toString();

        }

        @Override
        public void run() {
            try {
                synchronized (file) {
                    file.seek((long)this.number * 20 + number);
                    file.write(creatString(number).getBytes());
                    countDownLatch.countDown();
                }
            } catch (IOException exception) {
                LOG.severe(exception.getMessage());
            }
        }
    }

}

