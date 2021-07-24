package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Part2Test {

    private final List<Integer> array = new ArrayList<>();
    private final List<Integer> linked = new LinkedList<>();

    @Test
    public void test1(){
        array.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Part2.removeByIndex(array,3);
        Assert.assertEquals("3",Part2.convertToString(array));
    }
    @Test
    public void test2(){
        linked.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Part2.removeByIndex(linked,3);
        Assert.assertEquals("3",Part2.convertToString(linked));
    }
    @Test
    public void test3(){
        array.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Part2.removeByIterator(array,3);
        Assert.assertEquals("3",Part2.convertToString(array));
    }
    @Test
    public void test4(){
        linked.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Part2.removeByIterator(linked,3);
        Assert.assertEquals("3",Part2.convertToString(linked));
    }
}