package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>> {
    private Node<E> root;

    public boolean add(E value) {
        if (!containsNode(value)) {
            root = addRecursive(root, value);
            return true;
        }
        return false;
    }

    private Node<E> addRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }
        int resultOfComparing = value.compareTo(current.value);
        if (resultOfComparing < 0) {
            current.left = addRecursive(current.left, value);
        } else if (resultOfComparing > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private boolean containsNodeRecursive(Node<E> current, E value) {
        if (current == null) {
            return false;
        }
        int resultOfComparing = value.compareTo(current.value);
        if (resultOfComparing == 0) {
            return true;
        }
        return resultOfComparing < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(E value) {
        return containsNodeRecursive(root, value);
    }

    public void add(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    private Node<E> deleteRecursive(Node<E> current, E value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            } else {
                E smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }
        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private E findSmallestValue(Node<E> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public boolean remove(E element) {
        if (!containsNode(element)) {
            return false;
        }
        root = deleteRecursive(root, element);
        return true;
    }

    public void print() {
        if (root != null) {
            recursivePrint(root, 0);
        }
    }

    private void recursivePrint(Node<E> node, int depth) {
        if (node.left != null) {
            recursivePrint(node.left, depth + 1);
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(node.value);
        if (node.right != null) {
            recursivePrint(node.right, depth + 1);
        }
    }

    private static final class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}