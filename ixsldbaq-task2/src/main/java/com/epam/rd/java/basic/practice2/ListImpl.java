package com.epam.rd.java.basic.practice2;

import java.util.Iterator;


public class ListImpl implements List {

    private Node head;
    private Node last;

    int size = 0;

    public ListImpl() {

    }

    public ListImpl(int size) {

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


        private Node next  = head;
        private int nextIndex;

        public IteratorImpl() {
            //Empty
        }

        @Override
        public boolean hasNext() {
            return nextIndex != size;
        }

        @Override
        public Object next(){
            Node lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

    }


    @Override
    public void addFirst(Object element) {
        Node node = new Node(element, null);
        if (head == null) {
            head = node;
            ++size;
        } else {
            node.next = head;
            head = node;
            ++size;
        }
    }

    @Override
    public void addLast(Object element) {
        Node node = new Node(element, null);
        if (head == null) {
            head = node;
            ++size;
        } else {
            Node n = head;
            while (n.next != null)
                n = n.next;
            n.next = node;
            last = node;
            ++size;
        }
    }

    @Override
    public void removeFirst() {
        Node n = head.next;
        head.next = null;
        head = n;
        --size;
    }

    @Override
    public void removeLast() {
        Node n = head;
        Node m = head;
        while (n.next != null) {
            m = n;
            n = n.next;
        }
        m.next = null;
        last = m;
        --size;
    }

    @Override
    public Object getFirst() {
        if (head == null)
            return null;
        return head.data;
    }

    @Override
    public Object getLast() {
        if (last == null)
            return null;
        return last.data;
    }

    @Override
    public Object search(Object element) {
        Node n = head;
        while (n.next != null) {
            if (n.data.equals(element))
                return element;
            n = n.next;
            if (n.data == last.data)
                return n.data;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if(head==null){
            return false;
        }
        Node n = head;
        Node m = n;
        if (head.data.equals(element)) {
            head = head.next;
            --size;
            return true;
        } else if (element == null) {
            int i = 0;
            while (i < size) {
                if (n.data == null) {
                    if(n == last) {
                        last = m;
                        m.next = null;
                        --size;
                        return true;
                    }
                    else {
                        m.next = n.next;

                        --size;
                        return true;
                    }
                }
                m = n;
                n = n.next;
                ++i;
            }
        } else {
            int i = 0;
            while (i < size) {
                if(n.next!=null)
                    return false;
                if (n.data.equals(element)) {
                    m.next = n.next;
                    --size;
                    return true;
                }
                m = n;
                n = n.next;
                ++i;
                if(i==size)
                    break;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = head;
        if (head != null) {
            while (node.next != null) {
                sb.append(node.data);
                sb.append(", ");
                node = node.next;
            }
            sb.append(node.data);
        }
        sb.append("]");
        return new String(sb);
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.addLast(3);
        System.out.println(list.toString());
        System.out.println("First " + list.getFirst());
        System.out.println("Last " + list.getLast());
        list.removeLast();
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.addLast(null);
        System.out.println(list.toString());
        System.out.println(list.remove(3));
        System.out.println(list.toString());
        System.out.println("Last " + list.getLast());

    }
}
