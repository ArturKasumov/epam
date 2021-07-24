package com.epam.rd.java.basic.practice6.part3;

public class Parking {

    private final int[] array;
    private final int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }

    public boolean arrive(int k) {
        if (k > capacity || k < 0)
            throw new IllegalArgumentException();
        if (array[k] == 0) {
            array[k] = 1;
            return true;
        }
        for (int i = k; i < capacity; ++i) {
            if (array[i] == 0) {
                array[i] = 1;
                return true;
            }
        }
        for (int i = 0; i < k; ++i) {
            if (array[i] == 0) {
                array[i] = 1;
                return true;
            }
        }
        return false;
    }

    public boolean depart(int k) {
        if (k > capacity || k < 0)
            throw new IllegalArgumentException();
        if(array[k]==1){
            array[k]=0;
            return true;
        }
        return false;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<capacity;++i)
            sb.append(array[i]);
        System.out.println(sb);
    }
    public String printString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<capacity;++i)
            sb.append(array[i]);
        return sb.toString();
    }
}
