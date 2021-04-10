package com.chintan.ds;

public class LinkedList<T> {

    static Node head;

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        Node previous = null;
        Node current = node;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }

    void printList(Node<T> node) {
        if (node != null) {
            while(node.next != null) {
                System.out.print(node.data + " -> ");
                node = node.next;
            }
            System.out.print("null");
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.printList(list.head);

        head = list.reverse(head);
        System.out.println();

        list.printList(head);
    }
}
