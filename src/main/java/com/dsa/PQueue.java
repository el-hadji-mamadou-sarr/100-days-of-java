package com.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PQueue<T extends Comparable<T>> {
    private int heapSize, heapCapacity = 0;
    private List<T> heap = null;
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PQueue() {
        this(1);
    }

    public PQueue(int sz) {
        heap = new ArrayList<>(sz);
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");
        return heap.get(0);
    }

    // remove the top of the PQ
    public T poll() {
        return removeAt(0);
    }

    private T removeAt(int i) {
        if (isEmpty())
            return null;
        heapSize--;

        T removedData = heap.get(i);
        swap(i, heapSize);
        heap.set(heapSize, null);
        mapRemove(removedData, heapSize);

        if (i == heapSize)
            return removedData;

        T elem = heap.get(i);

        // try sinking
        sink(i);

        // if sinking doon't work try swim
        if (heap.get(i).equals(elem))
            swim(i);

        return removedData;
    }

    public boolean contains(T elem) {
        if (elem == null)
            return false;
        return map.containsKey(elem);
    }

    public void add(T elem) {
        if (elem == null)
            throw new IllegalArgumentException();
        if (heapSize < heapCapacity) {
            heap.set(heapSize, elem);
        } else {
            heap.add(elem);
            heapCapacity++;
        }

        mapAdd(elem, heapSize);
        swim(heapSize);
        heapSize++;
    }

    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    // from the bottom to the top
    private void swim(int k) {
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(k, parent);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            if (left >= heapSize || less(k, smallest))
                break;

            swap(k, smallest);
            k = smallest;

        }
    }

    private void swap(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);

        heap.set(i, node2);
        heap.set(j, node1);

        mapSwap(node1, node2, i, j);
    }

    public boolean remove(T elem) {
        if (elem == null)
            return false;

        Integer index = mapGet(elem);
        if (index != null)
            removeAt(index);
        return index != null;
    }

    private void mapAdd(T elem, int index) {
        TreeSet<Integer> set = map.get(elem);
        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(elem, set);
        } else {
            set.add(index);
        }
    }

    private void mapRemove(T elem, int index) {
        TreeSet<Integer> set = map.get(elem);
        set.remove(index);
        if (set.isEmpty())
            map.remove(elem);
    }

    private Integer mapGet(T elem) {
        TreeSet<Integer> set = map.get(elem);
        if (set != null)
            return set.last();
        return null;
    }

    private void mapSwap(T elem1, T elem2, int i, int j) {
        TreeSet<Integer> set1 = map.get(elem1);
        TreeSet<Integer> set2 = map.get(elem2);

        set1.remove(i);
        set1.add(j);

        set2.remove(j);
        set2.add(j);
    }

    @Override
    public String toString() {
        return heap.toString();
    }

}
