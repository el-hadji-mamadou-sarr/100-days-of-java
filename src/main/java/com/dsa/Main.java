package com.dsa;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        System.out.println(sll.toString());
        sll.insertAt(1, 10);
        System.out.println(sll.toString());
    }
}