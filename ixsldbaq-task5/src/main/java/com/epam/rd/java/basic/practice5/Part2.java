package com.epam.rd.java.basic.practice5;


import java.io.InputStream;
import java.util.logging.Logger;

public class Part2 {
    private static final Logger LOG = Logger.getLogger(Part2.class.getName());
    public static void main(final String[] args) {
        InputStream in = new InputStream() {
            @Override
            public int read() {
                return -1;
            }
        };
        System.setIn(in);
        Thread t = new Thread() {
            @Override
            public void run() {
                Spam.main(null);
            }
        };
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            LOG.severe(e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.setIn(System.in);

    }

}
