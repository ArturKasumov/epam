package com.epam.rd.java.basic.practice6.part2;

import java.util.*;

public class Part2 {
    private static final List<Integer> array = new ArrayList<>();
    private static final List<Integer> linked = new LinkedList<>();

    public static void main(String[] args) {
        array.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        linked.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        System.out.println("ArrayList#Index: " + removeByIndex(array, 3));
        System.out.println("LinkedList#Index: " + removeByIndex(linked, 3));
        array.clear();
        linked.clear();
        array.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        linked.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        System.out.println("ArrayList#Iterator: " + removeByIterator(array, 3));
        System.out.println("LinkedList#Iterator: " + removeByIterator(linked, 3));
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long start = System.currentTimeMillis();
        int i = 0;
        while (list.size() != 1) {
            i += k - 1;
            if (list.size() > i) {
                list.remove(i);
            } else {
                i = i - list.size();
                if (list.size() <= i) {
                    i = i - list.size();
                }
                list.remove(i);
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long start = System.currentTimeMillis();
        Iterator<Integer> itr = list.iterator();
        while(list.size()>1) {
            if(!itr.hasNext()) {
                itr = list.iterator();
            }
            int i = 0;
            while (itr.hasNext()) {
                itr.next();
                if (i % (k-1)  == 0) {
                    itr.remove();
                }
                i++;
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static String convertToString(final List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(Integer i : list)
            sb.append(i);
        return sb.toString();
    }
}
