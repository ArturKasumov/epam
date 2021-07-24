package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {


    public static String readFile(String fileName) {
        String string;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"))) {
            while ((string = reader.readLine()) != null) {
                sb.append(string).append(System.lineSeparator());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sb.toString().trim();
    }

    public static Iterator<String> iterator(String s) {
        String string = s;
        return new IteratorImpl(string);
    }

    public static class IteratorImpl implements Iterator<String> {

        Matcher matcher;
        Pattern pattern = Pattern.compile("(?s)\\b.+?\\.");

        public IteratorImpl(String string) {
            matcher = pattern.matcher(string);
        }

        @Override
        public boolean hasNext() {

            return matcher.find();
        }

        @Override
        public String next() {
            String s = matcher.group();
            s = s.replace(System.lineSeparator(), " ");
            return s;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        String string = readFile("part4.txt");
        Iterator<String> i = iterator(string);
        while (i.hasNext())
            System.out.println(i.next());
    }
}
