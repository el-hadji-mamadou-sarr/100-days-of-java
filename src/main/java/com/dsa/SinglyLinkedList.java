package com.dsa;

import java.util.EmptyStackException;

public class SinglyLinkedList<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        public T data;
        public Node next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.data = null;
            trav.next = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null);
        } else {

            Node<T> newNode = new Node<T>(elem, null);
            tail.next = newNode;
            tail = newNode;
        }
        size += 1;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null);
        } else {

            Node<T> oldHead = head;
            Node<T> newNode = new Node<T>(elem, oldHead);
            head = newNode;
            size += 1;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node<T> oldhead = head;
            head = oldhead.next;
            oldhead.data = null;
            oldhead.next = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node<T> prev = head;
            Node<T> trav = head.next;
            while (trav.next != null) {
                trav = trav.next;
                prev = prev.next;
                if (trav.next == null) {
                    trav.data = null;
                    prev.next = null;
                    tail = prev;
                    size--;
                }
            }
        }

    }

    private void remove(Node<T> node) {
        if (node.next == null)
            removeLast();

        else if (node == head)
            removeFirst();
        else {

            Node<T> prev = head;
            Node<T> trav = head.next;

            while (trav.next != null) {
                if (trav == node) {
                    prev.next = trav.next;
                    trav.data = null;
                    trav.next = null;
                    size--;
                } else {
                    trav = trav.next;
                    prev = prev.next;
                }
            }
        }

    }

    public void removeAt(int index) {
        if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            int i = 0;
            Node<T> trav = head;
            while (trav.next != null) {
                if (i == index) {
                    remove(trav);
                    break;
                }
                trav = trav.next;
                i++;
            }
        }
    }

    public void insertAt(int index, T elem) {
        if (index == 0)
            addFirst(elem);
        else if (index == size - 1)
            addLast(elem);
        else if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            int i = 0;
            Node<T> trav = head;
            while (trav.next != null) {
                if (i == index - 1) {
                    Node<T> newNode = new Node(elem, trav.next);
                    trav.next = newNode;
                    break;
                }
                trav = trav.next;
                i++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
