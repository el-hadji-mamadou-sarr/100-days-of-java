package com.dsa;

import java.util.EmptyStackException;

public class Stack<T> {
    Node<T> head = null;
    int size = 0;

    private class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void push(T data) {
        if (head == null)
            head = new Node<T>(data, null);
        else {
            Node<T> newNode = new Node<T>(data, head);
            head = newNode;
        }
        size++;
    }

    public void pop() {
        if (head == null)
            throw new EmptyStackException();
        else {
            Node<T> prev = head.next;
            head.data = null;
            head.next = null;
            head = prev;
            size--;
        }
    }

    public T peek() {
        return (head.data);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data + ",");
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();

    }
}
