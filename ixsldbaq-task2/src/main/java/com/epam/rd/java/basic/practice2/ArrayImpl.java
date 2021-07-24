package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    private int size = 0;

    public ArrayImpl() {
    }

    public ArrayImpl(int size) {
        this.size = size;
    }

    private Object[] arr = new Object[size];

    @Override
    public void clear() {
        arr = new Object[]{};
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        public IteratorImpl() {
            //Empty
        }

        private int pointer = -1;
        private int next;

        public boolean hasNext() {
            return next != arr.length;
        }

        @Override
        public Object next(){
            int i = next;
            if (i >= arr.length)
                throw new NoSuchElementException();
            next = i + 1;
            pointer = i;
            return arr[pointer];
        }

        @Override
        public void remove() {
            if (pointer < 0) {
                return;
            }
            ArrayImpl.this.remove(pointer);
            next = pointer;
            pointer = -1;
        }
    }


    @Override
    public void add(Object element) {
        Object[] arr2 = new Object[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        arr2[arr2.length - 1] = element;
        arr = arr2;
    }

    @Override
    public void set(int index, Object element) {
        arr[index] = element;
    }

    @Override
    public Object get(int index) {
        return arr[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = 0; i < arr.length; i++)
                if (element.equals(arr[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        Object[] arr2 = new Object[arr.length - 1];
        System.arraycopy(arr, 0, arr2, 0, index);
        System.arraycopy(arr, index + 1, arr2, index, arr.length - index - 1);
        arr = arr2;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; ++i) {
            if (i != arr.length - 1) {
                sb.append(arr[i]);
                sb.append(", ");
            } else
                sb.append(arr[i]);
        }
        sb.append("]");
        return new String(sb);
    }

    public static void main(String[] args) {
        ArrayImpl a = new ArrayImpl();
        a.add(1);
        a.add(2);
        a.add(3);
        a.remove(0);
        a.set(1, 10);
        System.out.println("Index 2 " + a.indexOf(5));
        System.out.println("Index 0 " + a.get(0));
        System.out.println("Size " + a.size());
        System.out.println(a.toString());
        a.clear();
        System.out.println(a.toString());
        a.add(1);
        a.add(2);
        a.add(3);
        Iterator<Object> i = a.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
            i.remove();
        }
        System.out.println(a.toString());
    }

}
