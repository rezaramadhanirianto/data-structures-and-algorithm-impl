package com.rezaramadhanirianto.dsaImpl.algorithm.recursion;

// Linked List Class
class MergeSortedLinkedList {

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

    public Node sortedMerge(Node node1, Node node2){
        if(node1 == null) return node2;
        else if(node2 == null) return node1;

        if(node1.data < node2.data){
            node1.next = sortedMerge(node1.next, node2);
            return node1;
        }else{
            node2.next = sortedMerge(node1, node2.next);
            return node2;
        }
    }

    public static void main(String[] args){
        Node b = new Node(1);
        b.next = new Node(2);
        b.next.next = new Node(4);
        b.next.next.next = new Node(5);
        b.next.next.next.next = new Node(6);
        Node a = new Node(7);
        a.next = new Node(8);
        a.next.next = new Node(9);
        a.next.next.next = new Node(9);

        MergeSortedLinkedList mergeSortedLinkedList = new MergeSortedLinkedList();
        var node = mergeSortedLinkedList.sortedMerge(a, b);
        mergeSortedLinkedList.printlist(node);
    }
}