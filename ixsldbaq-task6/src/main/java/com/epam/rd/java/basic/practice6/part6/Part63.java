package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.Locale;

public class Part63{
    public static void main(String[] args) {
        String s = args[0];
        String[] a = s.split(" ");
        String[] res = new String[1000];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].equals(a[j])) {
                    a[j] = "0";
                    res[count]=a[i];
                    count++;
                }
            }
        }
        Object[] tmp;
        tmp= Arrays.stream(res).distinct().toArray();
        for (int i = 0; i < 3; ++i) {
            System.out.println(reverseString( tmp[i].toString().toUpperCase(Locale.ROOT)));
        }
    }
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
