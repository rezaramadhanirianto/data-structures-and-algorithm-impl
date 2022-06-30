package com.rezaramadhanirianto.dsaImpl.algorithm.recursion;

public class ReverseLinkedList {
    Node head;
    static Node a, b;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public Node reverseLinkedList(Node head){
        if(head == null || head.next == null) return head;
        var node = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args){
        Node b = new Node(1);
        b.next = new Node(2);
        b.next.next = new Node(4);
        b.next.next.next = new Node(5);
        b.next.next.next.next = new Node(6);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        var list = reverseLinkedList.reverseLinkedList(b);
        reverseLinkedList.printlist(list);
    }
}
