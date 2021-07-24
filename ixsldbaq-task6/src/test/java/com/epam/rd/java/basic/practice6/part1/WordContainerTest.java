package com.epam.rd.java.basic.practice6.part1;


import org.junit.Assert;
import org.junit.Test;


public class WordContainerTest {
    @Test
    public void test1() {
        WordContainer.addWord("a");
        WordContainer.addWord("b");
        WordContainer.addWord("a");
        Assert.assertEquals("a : 2b : 1",WordContainer.print());
    }

    @Test
    public void test2() {
        WordContainer.addWord("a");
        WordContainer.addWord("b");
        WordContainer.addWord("c");
        Assert.assertEquals("a : 3b : 2c : 1",WordContainer.print());
    }
}
