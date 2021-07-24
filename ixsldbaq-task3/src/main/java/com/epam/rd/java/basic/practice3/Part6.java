package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String s = Util.getInput("part6.txt");
        System.out.println(convert(s));
    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("(?s)\\b.+?(?<=\\b| )");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            if (check(input, matcher.group())) {
                sb.append("_").append(matcher.group());
            } else
                sb.append(matcher.group());
        }
        return sb.toString().trim();
    }

    private static boolean check(String input, String word) {
        if(word.equals(" ") || word.equals("\n"))
            return false;
        String[] arr = input.split("[ |\n]");
        String[] arr1 = new String[arr.length];
        for(int i=0;i<arr.length;++i){
            if(arr[i].equals(word)){
                System.arraycopy(arr,i+1,arr1,0,arr.length-i-1);
                break;
            }
        }
        for(int i=0;i<arr1.length;++i){
            if(arr1[i]!=null)
            if(arr1[i].equals(word)){
               return true;
            }
        }
        return false;
    }
}
