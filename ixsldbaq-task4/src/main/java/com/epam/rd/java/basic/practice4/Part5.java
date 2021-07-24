package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Properties;

public class Part5 {

    public static void main(String[] args) {
        func();
    }

    public static void func() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean loop = true;
            while (loop) {
                String[] arr = reader.readLine().split(" ");
                if (!arr[0].contains("stop")) {
                    switch (arr[1]) {
                        case "ru":
                            forRu(arr[0]);
                            break;
                        case "en":
                            forEn(arr[0]);
                            break;
                        case "stop":
                            loop = false;
                            break;
                        default:
                            System.out.println("wrong");
                            break;
                    }
                } else {
                    loop = false;
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void forRu(String string) {
        try (BufferedReader readerForRu = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources_ru.properties"), "cp1251"))) {
            Properties prop = new Properties();
            prop.load(readerForRu);

            System.out.println(prop.getProperty(string));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void forEn(String string) {
        try (BufferedReader readerForEn = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources_en.properties"), "cp1251"))) {
            Properties prop = new Properties();
            prop.load(readerForEn);

            System.out.println(prop.getProperty(string));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
