package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;

public class RangeTest {

    @Test
    public void standartOutput(){
        Range range = new Range(5,10);
        StringBuilder sb = new StringBuilder();
        for(Integer j:range)
            sb.append(j).append(" ");
        Assert.assertEquals(sb.toString(),"5 6 7 8 9 10 ");
    }

    @Test
    public void reverseOutput(){
        Range range = new Range(5,10,true);
        StringBuilder sb = new StringBuilder();
        for(Integer j:range)
            sb.append(j).append(" ");
        Assert.assertEquals(sb.toString(),"10 9 8 7 6 5 ");
    }
}
