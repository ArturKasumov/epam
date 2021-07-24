package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        print(readFile("part3.txt"));
    }

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"))) {
            while ((s = reader.readLine()) != null)
                sb.append(s).append(System.lineSeparator());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sb.toString().trim();
    }

    public static void print(String string) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            Pattern pattern;
            Matcher matcher;
            boolean loop = true;
            while (loop) {
                switch (reader.readLine()) {
                    case "String":
                        pattern = Pattern.compile("(?i)[a-zа-яёієїэ]{2,}");
                        matcher = pattern.matcher(string);
                        while (matcher.find())
                            sb.append(matcher.group()).append(" ");
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                        break;
                    case "char":
                        pattern = Pattern.compile("\\b[A-za-я]\\b");
                        matcher = pattern.matcher(string);
                        while (matcher.find())
                            sb.append(matcher.group()).append(" ");
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                        break;
                    case "int":
                        pattern = Pattern.compile("(?<!\\.)[0-9]{2,}(?!\\.)");
                        matcher = pattern.matcher(string);
                        while (matcher.find())
                            sb.append(matcher.group()).append(" ");
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                        break;
                    case "double":
                        pattern = Pattern.compile("[0-9]*\\.[0-9]+");
                        matcher = pattern.matcher(string);
                        while (matcher.find())
                            sb.append(matcher.group()).append(" ");
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                        break;
                    case "stop":
                        loop = false;
                        break;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
