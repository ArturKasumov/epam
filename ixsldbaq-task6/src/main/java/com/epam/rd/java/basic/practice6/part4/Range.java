package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private static int[] array;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        array = new int[secBound - firstBound + 1];
        if (!reversedOrder) {
            int j = firstBound;
            for (int i = 0; i <= secBound - firstBound; ++i) {
                array[i] = j++;
            }
        } else {
            int j = secBound;
            for (int i = 0; i <= secBound - firstBound; ++i) {
                array[i] = j--;
            }
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {
        private int cursor = 0;
        private final int size = array.length;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Integer next() {
            return array[cursor++];
        }

    }

}
