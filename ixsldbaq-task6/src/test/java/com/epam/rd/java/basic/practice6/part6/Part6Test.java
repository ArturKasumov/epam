package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.part5.Tree;
import org.junit.Assert;
import org.junit.Test;

public class Part6Test {
    @Test
    public void test1(){
        String s = "hi how are";
        Part61.main(new String[]{s});
        Assert.assertEquals(1,Part61.countOccurences(s.split(" "),"how"));
    }

    @Test
    public void test2(){
        String s = "hi how are";
        Part61.main(new String[]{s});
    }
}
