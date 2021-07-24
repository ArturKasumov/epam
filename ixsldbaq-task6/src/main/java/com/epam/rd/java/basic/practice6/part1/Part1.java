package com.epam.rd.java.basic.practice6.part1;


import java.io.ByteArrayInputStream;


public class Part1 {

    public static void main(String[] args) {
        String s = "A C B" + System.lineSeparator() +
                "C A B" + System.lineSeparator() +
                "C A stop C A B" + System.lineSeparator() +
                "stop";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        Thread t = new Thread(() -> WordContainer.main(null));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
        System.setIn(System.in);
    }

}
