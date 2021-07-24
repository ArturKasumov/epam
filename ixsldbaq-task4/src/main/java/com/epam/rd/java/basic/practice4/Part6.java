package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        print(readFile("part6.txt"));
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
        return sb.toString();
    }


    public static void print(String string) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            Pattern pattern;
            Matcher matcher;
            boolean loop = true;
            while (loop) {
                String s = reader.readLine();
                switch (s.toLowerCase()) {
                    case "cyrl":
                        sb.append(s).append(": ");
                        pattern = Pattern.compile("(?iu)[а-яёієїэ]+");
                        matcher = pattern.matcher(string);
                        while (matcher.find())
                            sb.append(matcher.group()).append(" ");
                        System.out.println(sb.toString());
                        sb.delete(0, sb.length());
                        break;
                    case "latn":
                        sb.append(s).append(": ");
                        pattern = Pattern.compile("(?i)[a-z]+");
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
                        System.out.println(s + ": " + "Incorrect input");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
