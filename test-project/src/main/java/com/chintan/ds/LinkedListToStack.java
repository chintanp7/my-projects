package com.chintan.ds;

public class LinkedListToStack {

    private static Node<Integer> head = null;

    private static void push(Integer data) {
        Node<Integer> node = new Node<>(data);

        node.next = head;
        head = node;
    }

    private static Node<Integer> pop() {
        Node<Integer> node = head;
        head = head.next;
        return node;
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);

        while (head != null) {
            System.out.println(pop());
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
            "data=" + data +
            '}';
    }
}
