package com.epam.rd.java.basic.practice6.part5;

import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void test1(){
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(2);
        Assert.assertTrue(integerTree.add(1));
    }
    @Test
    public void test2(){
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(1);
        Assert.assertFalse(integerTree.add(1));
    }
    @Test
    public void test3(){
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(1);
        Assert.assertTrue(integerTree.containsNode(1));
    }
    @Test
    public void test4(){
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(1);
        Assert.assertFalse(integerTree.containsNode(2));
    }
    @Test
    public void test5(){
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(1);
        Assert.assertTrue(integerTree.remove(1));
    }
    @Test
    public void test6(){
        Tree<Integer> integerTree = new Tree<>();
        integerTree.add(1);
        Assert.assertFalse(integerTree.remove(2));
    }

}
