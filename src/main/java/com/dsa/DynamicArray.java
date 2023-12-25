package com.dsa;

public class DynamicArray <T> {
    private int size = 0;
    private int capacity = 0;
    private T[] array;
    
    public DynamicArray() {
        this(16);
    }
    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return array[index];
    }
    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        array[index] = element;
    }
    public void clear() {
        for (int i = 0; i < size; i++) array[i] = null;
        size = 0;
    }
    public void add(T element) {
        if (size + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) newArray[i] = array[i];
            array = newArray;
        }
        array[size++] = element;
    }
    // public T removeAt(int index){
    //     if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

    // }
}
