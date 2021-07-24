package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Random;


public class Part2 {

    private static final String ENCODING = "cp1251";

    public static void main(String[] args) {
        String fromFileName = "part2.txt";
        String toFileName = "part2_sorted.txt";
        System.out.println("input ==> " + creatAndFillFile(fromFileName));
        System.out.println("output ==> " + readFileThenWriteToAnother(fromFileName, toFileName));
    }

    public static String creatAndFillFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        boolean isExist = file.exists();
        if (!isExist) {
            try {
                isExist = file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if (isExist) {
            Random random = new Random();
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), ENCODING)) {
                for (int i = 0; i < 10; ++i) {
                    int j = random.nextInt(51);
                    writer.write(String.valueOf(j));
                    sb.append(j);
                    if (i != 9) {
                        writer.write(" ");
                        sb.append(" ");
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String readFileThenWriteToAnother(String fromFile, String toFile) {

        StringBuilder res = new StringBuilder();
        File file = new File(toFile);
        boolean isExist = file.exists();
        if (!isExist) {
            try {
                isExist = file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        String string;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fromFile), ENCODING))) {
            while ((string = reader.readLine()) != null) {
                sb.append(string);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        string = sb.toString();
        string = sorting(string);
        if (isExist) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toFile), ENCODING))) {
                writer.write(string);
                res.append(string);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return res.toString();
    }


    public static String sorting(String arr) {
        String[] array = arr.split(" ");
        for (int i = 0; i < array.length - 1; ++i)
            for (int j = 0; j < array.length - 1 - i; ++j) {
                if (Integer.parseInt(array[j]) > Integer.parseInt(array[j + 1])) {
                    String c = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = c;
                }
            }
        return String.join(" ", array).trim();
    }
}