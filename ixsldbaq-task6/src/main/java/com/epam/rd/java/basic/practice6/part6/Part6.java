package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part6 {


    public static void main(String[] args) {
        String s = read(args[1]);
        switch (args[3]){
            case "frequency":
                Part61.main(new String[]{s});
                break;
            case "length":
                Part62.main(new String[]{s});
                break;
            case "duplicates":
                Part63.main(new String[]{s});
                break;
            default:
        }
    }

    public static String read(String path) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            sb.append(scanner.nextLine().trim()).append(" ");
        }
        scanner.close();
        return sb.toString().trim();
    }
    
}
