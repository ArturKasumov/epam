package com.epam.rd.java.basic.practice6.part3;

import org.junit.*;

public class ParkingTest {
    Parking parking = new Parking(4);
    @Test
    public void test1(){
       parking.arrive(1);
       Assert.assertEquals("0100",parking.printString());
    }
    @Test
    public void test2(){
        parking.arrive(1);
        parking.arrive(1);
        Assert.assertEquals("0110",parking.printString());
    }
    @Test
    public void test3(){
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        Assert.assertEquals("1111",parking.printString());
    }
    @Test
    public void test4(){
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        Assert.assertFalse(parking.arrive(1));
    }
    @Test
    public void test5(){
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        Assert.assertTrue(parking.arrive(1));
    }
    @Test
    public void test6(){
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        parking.arrive(1);
        Assert.assertTrue(parking.depart(1));
    }
    @Test
    public void test7(){
        Assert.assertFalse(parking.depart(1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test8(){
        parking.arrive(5);
    }
}