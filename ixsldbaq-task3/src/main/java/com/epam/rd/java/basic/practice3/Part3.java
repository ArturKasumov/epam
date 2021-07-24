package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String s = Util.getInput("part3.txt");
        System.out.println(convert(s));
    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("(?s).+?\\b");
        Matcher matcher = pattern.matcher(input);
        StringBuilder res = new StringBuilder();
        while (matcher.find()) {
            if (matcher.group().length() >= 3) {
                if (Character.isLowerCase(matcher.group().charAt(0))) {
                    res.append(matcher.group().substring(0, 1).toUpperCase()).append(matcher.group().substring(1));
                } else if (Character.isUpperCase(matcher.group().charAt(0))) {
                    res.append(matcher.group().substring(0, 1).toLowerCase()).append(matcher.group().substring(1));
                }
            } else {
                res.append(matcher.group());
            }
        }
        return res.toString().trim();

    }
}
