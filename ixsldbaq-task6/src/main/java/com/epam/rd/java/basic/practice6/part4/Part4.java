package com.epam.rd.java.basic.practice6.part4;

public class Part4 {

    public static void main(String[] args) {
       Range range = new Range(5,10,true);
       for(Integer el: range){
           System.out.printf("%d ",el);
       }
    }
}
