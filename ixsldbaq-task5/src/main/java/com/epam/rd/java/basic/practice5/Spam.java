package com.epam.rd.java.basic.practice5;
import java.util.Scanner;
import java.util.logging.Logger;

public class Spam {
    private static final Logger LOG = Logger.getLogger(Spam.class.getName());
    private Thread[] threads;
    private  String[] messages;
    private  int[] delays;

    public Spam(final String[] messages, final int[] delays) {
        this.messages = messages;
        this.delays = delays;
        threads = new Thread[messages.length];
    }

    public static void main(final String[] args) {
        String[] messages = new String[]{"@@@", "bbbbbbb"};
        int[] times = new int[]{333, 222};

        Spam spam = new Spam(messages, times);
        spam.start();

        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            spam.stop();
        }
        spam.stop();
    }

    public void start() {
       for(int i=0;i<threads.length;++i){
           threads[i] = new Worker(messages[i],delays[i]);
           threads[i].start();
       }
    }

    public void stop() {
        for (Thread thread : threads) {

            thread.interrupt();

            try {
                thread.join();
            } catch (InterruptedException e) {
                LOG.severe(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class Worker extends Thread {
        String messages;
        int delays;

        Worker(String messages, int delay) {
            this.messages = messages;
            this.delays = delay;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(messages);
                try {
                    sleep(delays);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

