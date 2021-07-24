package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {
    private int size;
    private Node head;
    private Node last;

    public StackImpl() {
        // Empty
    }

    private static class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        Node x = head;
        Node next;
        for (; x != null; x = next) {
            next = x.next;
            x.data = null;
            x.next = null;

        }
        head = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int pointer;
        private Node next = head;

        public IteratorImpl() {
            //Empty
        }

        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        @Override
        public Object next() {
            Node lastReturned = next;
            next = next.next;
            ++pointer;
            return lastReturned.data;
        }

    }

    @Override
    public void push(Object element) {
        Node node = new Node(element, null);
        if (head == null) {
            head = node;
            last = node;
            ++size;
        } else {
            node.next = head;
            head = node;
            ++size;
        }
    }

    @Override
    public Object pop() {
        if (last == null)
            return null;
        else {
            Node n = head;
            Node m = n;
            head = n.next;
            n = null;
            --size;
            return m.data;

        }
    }

    @Override
    public Object top() {
        if (last != null)
            return head.data;
        else
            return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = head;
        if (head != null) {
            while (n.next != null) {
                sb.append(n.data);
                sb.append(",");
                n = n.next;
            }
            sb.append(n.data);
        }
        String s = sb.toString();
        String[] strs = s.split(",");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for (int i = strs.length - 1; i >= 0; --i) {
            if (i == 0)
                sb1.append(strs[i]);
            else {
                sb1.append(strs[i]);
                sb1.append(", ");
            }
        }
        sb1.append("]");
        return sb1.toString();
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);
    }

}
