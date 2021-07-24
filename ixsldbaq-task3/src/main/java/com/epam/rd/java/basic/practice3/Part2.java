package com.epam.rd.java.basic.practice3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        String s = Util.getInput("part2.txt");
        System.out.println(convert(s));

    }

    public static String convert(String input) {
        StringBuilder res=new StringBuilder("Min: ");
        Pattern p=Pattern.compile("(?m)\\b[A-z]+?\\b");
        Matcher m=p.matcher(input);

        String[] a=new String[10];
        String[] b=new String[10];

        m.find();
        int min=m.group().length();
        int max=m.group().length();
        a[0]=m.group();
        b[0]=m.group();
        int i=0;
        int j=0;
        while (m.find())
        {
            if(m.group().length()<min){
                a=new String[10];
                min=m.group().length();
                a[0]=m.group();
                i=1;
            }
            if(m.group().length()==min){
                for(int h=0;h<a.length;++h)
                {
                    if(!m.group().equals(a[h])&&a[h]!=null)
                    {
                        a[i]=m.group();
                        i++;
                    }
                    break;
                }
            }
            if(m.group().length()>max){
                b=new String[10];
                max=m.group().length();
                b[0]=m.group();
                j=1;
            }
            if(m.group().length()==max){
                for(int h=0;h<b.length;++h)
                {
                    if(!m.group().equals(b[h])&&b[h]!=null)
                    {
                        b[j]=m.group();
                        j++;
                    }
                    break;
                }
            }
        }
        for(String s:a){
            if(s != null) {
                res.append(s).append(", ");
            }
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.append("\n").append("Max: ");
        for(String s:b){
            if(s != null) {
                res.append(s).append(", ");
            }
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
