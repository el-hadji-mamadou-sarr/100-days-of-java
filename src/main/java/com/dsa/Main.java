package com.dsa;

public class Main {
    public static void main(String[] args) {
        PQueue<Integer> pq = new PQueue<>();
        pq.add(1);
        pq.add(5);
        pq.add(8);
        pq.add(4);
        pq.add(2);

        System.out.println(pq.toString());

        pq.remove(8);
        System.out.println(pq.toString());
        pq.add(2);
        System.out.println(pq.toString());
    }
}