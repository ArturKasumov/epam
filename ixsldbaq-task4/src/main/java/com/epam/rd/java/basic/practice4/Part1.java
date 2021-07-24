package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String fileName = "part1.txt";
        System.out.println(convert(fileName));
    }

    public static String convert(String fileName) {
        String s = readFile(fileName, "cp1251");
        Pattern pattern = Pattern.compile("(?s).+?\\b");
        Matcher matcher = pattern.matcher(s);
        StringBuilder res = new StringBuilder();
        while (matcher.find()) {
            if (matcher.group().length() >= 4) {
                res.append(matcher.group().substring(2));
            } else
                res.append(matcher.group());
        }
        return res.toString().trim();
    }


    static String readFile(String fileName, String encoding) {
        StringBuilder sb = new StringBuilder();
        int i;
        try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(fileName), encoding)) {
            while((i=inputStream.read())!=-1)
                sb.append((char)i);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sb.toString();
    }
}