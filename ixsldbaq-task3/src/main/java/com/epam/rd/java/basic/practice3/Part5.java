package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        System.out.println(decimal2Roman(39));
        System.out.println(roman2Decimal("XXXIX"));
    }

    public static String decimal2Roman(int dec) {
        if (dec < 1 || dec > 100)
            return "Invalid Roman Number Value";
        StringBuilder sb = new StringBuilder();
        while (dec >= 100) {
            sb.append("C");
            dec -= 100;
        }
        while (dec >= 90) {
            sb.append("XC");
            dec -= 90;
        }
        while (dec >= 50) {
            sb.append("L");
            dec -= 50;
        }
        while (dec >= 40) {
            sb.append("XL");
            dec -= 40;
        }
        while (dec >= 10) {
            sb.append("X");
            dec -= 10;
        }
        while (dec >= 9) {
            ;
            sb.append("IX");
            dec -= 9;
        }
        while (dec >= 5) {
            sb.append("V");
            dec -= 5;
        }
        while (dec >= 4) {
            sb.append("IV");
            dec -= 4;
        }
        while (dec >= 1) {
            sb.append("I");
            dec -= 1;
        }
        return sb.toString();
    }

    public static int roman2Decimal(String roman) {
        char[] ch = roman.toCharArray();
        int sum = 0;
        int j = 0;
        for (int i = 0; i < ch.length; ++i) {
            j = convert(ch[i]);
            if (i != ch.length - 1) {
                if (j >= convert(ch[i + 1]))
                    sum += j;
                else {
                    sum = sum + convert(ch[i + 1]) - j;
                    ++i;
                }
            } else
                sum += j;
        }
        return sum;
    }

    private static int convert(char ch) {
        if (ch == 'I')
            return 1;
        if (ch == 'V')
            return 5;
        if (ch == 'X')
            return 10;
        if (ch == 'L')
            return 50;
        if (ch == 'C')
            return 100;
        return -1;
    }
}
