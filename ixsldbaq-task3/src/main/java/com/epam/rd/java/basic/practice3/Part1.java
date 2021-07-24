package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String s = Util.getInput("part1.txt");
        System.out.println(convert1(s));
        System.out.println(convert2(s));
        System.out.println();
        System.out.println(convert3(s));
        System.out.println();
        System.out.println(convert4(s));

    }

    private static String[] name;
    private static String[] fullName;
    private static String[] mail;


    private static void pasreData(String input) {
        Pattern pattern = Pattern.compile("(?m)^(.+?);(.+?);(.+?)$");
        Matcher matcher = pattern.matcher(input);
        Matcher matcher2 = pattern.matcher(input);
        int size = 0;
        matcher2.find();
        while (matcher2.find()) {
            ++size;
        }
        name = new String[size];
        fullName = new String[size];
        mail = new String[size];

        int i = 0;
        matcher.find();
        while (matcher.find()) {
            name[i] = matcher.group(1);
            fullName[i] = matcher.group(2);
            mail[i] = matcher.group(3);
            ++i;
        }
    }

    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(?m)^(.+?);(.+?);(.+?)$");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        while (matcher.find()) {
            sb.append(matcher.group(1)).append(": ").append(matcher.group(3)).append("\n");
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        pasreData(input);
        for (int i = 0; i < name.length; ++i) {
            String[] s = fullName[i].split(" ");
            sb.append(s[1]).append(" ").append(s[0]).append(" (email: ").append(mail[i]).append(")").append("\n");
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(?m)^(.+?);(.+?);(.+?mail.com)$");
        Pattern pattern1 = Pattern.compile("(?m)^(.+?);(.+?);(.+?mail.com)$");
        Pattern pattern2 = Pattern.compile("(?m)^(.+?);(.+?);(.+?google.com)$");
        Matcher matcher = pattern.matcher(input);
        Matcher matcher1 = pattern1.matcher(input);
        sb.append("mail.com ==> ");
        int i = 0;
        int k = 0;
        while (matcher1.find()) {
            i++;
        }
        String[] s = new String[i];
        while (matcher.find()) {
            s[k++] = matcher.group(1);
        }
        for (int j = 0; j < s.length; ++j) {
            if (j == s.length - 1)
                sb.append(s[j]);
            else sb.append(s[j] + ", ");
        }

        Matcher matcher2 = pattern2.matcher(input);
        sb.append("\n").append("google.com ==> ");
        while (matcher2.find()) {
            sb.append(matcher2.group(1)).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length() - 1, "");
        sb = new StringBuilder(sb.toString().trim());
        sb.append("\n");
        return sb.toString();
    }

    public static String convert4(String input) {
        StringBuilder sb = new StringBuilder();
        int min = 1000;
        int max = 9999;
        double r;
        Pattern pattern = Pattern.compile("(?m)^.+$");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        sb.append(matcher.group()).append(";Password").append("\r\n");
        while (matcher.find()) {
            r = min + Math.random() * (max - min);
            sb.append(matcher.group()).append(";").append((int) r).append("\r\n");
        }
        return sb.toString().trim();
    }
}