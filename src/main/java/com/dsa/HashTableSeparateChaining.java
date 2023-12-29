package com.dsa;

import java.util.Arrays;
import java.util.LinkedList;

class Entry<K, V> {
    int hash;
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        // if they hve different hash i am sure they are not equal
        if (hash != other.hash)
            return false;

        // if they have same hash, i compare their keys
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + " => " + value;
    }
}

public class HashTableSeparateChaining<K, V> {

    // default capa
    private static final int DEFAULT_CAPACITY = 3;

    // treshold => 0.75*3 = 2 by default
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxLoadFactor;
    private int capacity, treshold, size = 0;

    private LinkedList<Entry<K, V>>[] table;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0)
            throw new IllegalArgumentException(" capacity can't be negatif");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("illegal maxLoadFactor");
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.treshold = (int) (this.capacity * maxLoadFactor);
        table = new LinkedList[this.capacity];

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // to have a positive int
    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(K key) {
        return hasKey(key);
    }

    public boolean hasKey(K key) {
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex, key) != null;
    }

    public V put(K key, V value) {
        return insert(key, value);
    }

    public V add(K key, V value) {
        return insert(key, value);
    }

    private V insert(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("key can't be null");
        Entry<K, V> entry = new Entry(key, value);
        int bucketIndex = normalizeIndex(entry.hash);
        return bucketInsertEntry(bucketIndex, entry);
    }

    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("key can't be null");
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry == null)
            return null;
        return entry.value;
    }

    public V remove(K key) {
        if (key == null)
            throw new IllegalArgumentException("key can't be null");
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }

    private V bucketRemoveEntry(int bucketIndex, K key) {

        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry == null)
            return null;
        LinkedList<Entry<K, V>> list = table[bucketIndex];
        list.remove(entry);
        --size;
        return entry.value;
    }

    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null)
            return null;
        LinkedList<Entry<K, V>> list = table[bucketIndex];
        if (list == null)
            return null;
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key))
                return entry;
        }
        return null;
    }

    private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null)
            table[bucketIndex] = bucket = new LinkedList<Entry<K, V>>();

        Entry<K, V> existentEntry = bucketSeekEntry(bucketIndex, null);
        if (existentEntry != null) {
            V oldVal = existentEntry.value;
            existentEntry.value = entry.value;
            return oldVal;
        } else {
            bucket.add(entry);
            if (++size > treshold)
                resizeTable();
            return null; // there were no other previous entry
        }

    }

    private void resizeTable() {
        capacity *= 2;
        treshold = (int) (capacity * maxLoadFactor);

        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    int bucketIndex = normalizeIndex(entry.key.hashCode());
                    LinkedList<Entry<K, V>> bucket = newTable[bucketIndex];
                    if (bucket == null)
                        newTable[bucketIndex] = bucket = new LinkedList<Entry<K, V>>();
                    newTable[bucketIndex].add(entry);
                }
            }
            table[i].clear();
            table[i] = null;
        }
        table = newTable;
    }
}
