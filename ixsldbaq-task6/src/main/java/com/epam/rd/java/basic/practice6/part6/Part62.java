package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.HashSet;

public class Part62 {
    public static void main(String[] args) {
        String s = args[0];
        String[] a = s.split(" ");
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(a));
        String[] unique = uniqueWords.toArray(new String[0]);
        for (int i = 0; i < unique.length - 1; i++) {
            for (int j = 0; j < unique.length - i - 1; j++) {
                if (unique[j].length() > unique[j + 1].length()) {
                    String tmp = unique[j];
                    unique[j] = unique[j + 1];
                    unique[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < unique.length - 1; i++) {
            for (int j = 0; j < unique.length - i - 1; j++) {
                if (unique[j].length() == unique[j + 1].length()) {
                    int c = 0;
                    for (int h = 0; h < a.length; ++h) {
                        if (unique[j].equals(a[h])) {
                            c = h;
                            break;
                        }
                    }
                    int d = 0;
                    for (int e = 0; e < a.length; ++e) {
                        if (unique[j+1].equals(a[e])) {
                            d = e;
                            break;
                        }
                    }
                    if (c < d) {
                        String tmp = unique[j];
                        unique[j] = unique[j + 1];
                        unique[j + 1] = tmp;
                    }
                }
            }
        }
        for (int i= unique.length-1;i>=unique.length-3;i--) {
            System.out.println(unique[i]+" ==> "+unique[i].length());
        }
    }
}
