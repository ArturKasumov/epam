package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {
    private Node head;
    private int size = 0;

    public QueueImpl() {
        //Empty
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
        head = null;
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
            return pointer<size;
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
    public void enqueue(Object element) {
        Node node = new Node(element, null);
        if (head == null) {
            head = node;
            ++size;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
            ++size;
        }
    }

    @Override
    public Object dequeue() {
        Object i;
        if(head==null)
            return null;
        else{
            Node n = head;
            i = n.data;
            head = head.next;
            size--;
            return i;
        }
    }

    @Override
    public Object top() {
        if (head != null)
            return head.data;
        else
            return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node n = head;
        if (head != null) {
            while (n.next != null) {
                sb.append(n.data);
                sb.append(", ");
                n = n.next;
            }
            sb.append(n.data);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(5);
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.clear();
        System.out.println(queue.toString());
        System.out.println(queue.top());
    }

}
