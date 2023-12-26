package com.dsa;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {
    LinkedList<T> list = new LinkedList<T>();

    public Queue() {
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        if (isEmpty())
            throw new EmptyStackException();
        return list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean contains(T data) {
        return list.contains(data);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
