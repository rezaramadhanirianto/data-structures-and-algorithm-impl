package com.rezaramadhanirianto.dsaImpl.datastructures.skiplist;

import java.util.ArrayList;
import java.util.List;

public class SkipList{

    private Node head;
    private Node tail;

    SkipList(){
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);

        head.right = tail;
        tail.left = head;
    }

    public Node search(int value){
        Node curr = head;

        while(curr != null){
            while(curr.right != null && curr.right.element < value){
                curr = curr.right;
            }

            if(curr.element == value) break;
            curr = curr.bottom;
        }
        return curr;
    }

    public boolean insert(int data){
        List<Node> needToUpdates = new ArrayList<>();
        Node curr = head;
        while(curr != null){
            while(curr.right != null && curr.right.element < data){
                curr = curr.right;
            }

            needToUpdates.add(curr);
            curr = curr.bottom;
        }

        int level = 0;
        Node newNode = null;
        while(level == 0 || flipCoin()){
            if(newNode == null) newNode = new Node(data);
            else newNode = new Node(newNode);

            Node nodeToUpdate;
            if(needToUpdates.size() <= level){
                createNewLayer();
                nodeToUpdate = this.head;
            } else{
                nodeToUpdate = needToUpdates.get(needToUpdates.size() - level -1);
            }

            // insert
            newNode.right = nodeToUpdate.right;
            newNode.left = nodeToUpdate;

            newNode.right.left = newNode;
            nodeToUpdate.right = newNode;

            level++;
        }
        return true;
    }

    private void createNewLayer() {
        Node newHead = new Node(Integer.MIN_VALUE);
        Node newTail = new Node(Integer.MAX_VALUE);

        newHead.right = newTail;
        newTail.left = newHead;

        head.top = newHead;
        newHead.bottom = head;
        head = newHead;

        tail.top = newTail;
        newTail.bottom = tail;
        tail = newTail;
    }

    public boolean delete(int data) {
        List<Node> pointersToUpdate = new ArrayList<>();

        Node curr = this.head;
        while (curr != null) {
            while (curr.right != null && curr.right.element < data ) {
                curr = curr.right;
            }

            if (curr.right.element == data) {
                pointersToUpdate.add(curr);
            }

            curr = curr.bottom;
        }

        for (int i = 0; i < pointersToUpdate.size(); i++) {
            Node nodeToUpdate = pointersToUpdate.get(i);
            Node nodeToDelete = nodeToUpdate.right;

            nodeToUpdate.right = nodeToDelete.right;
            nodeToDelete.right.left = nodeToUpdate;

            nodeToDelete.top = null;
            nodeToDelete.bottom = null;
        }

        return true;
    }

    private boolean flipCoin() {
        return Math.random() >= 0.5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = this.head;

        while (curr != null) {
            Node firstInLevel = curr;
            firstInLevel = firstInLevel.right;

            while (firstInLevel.right != null) {
                sb.append(firstInLevel.element + " ");
                firstInLevel = firstInLevel.right;
            }

            curr = curr.bottom;
            sb.append("\n");
        }
        return sb.toString();
    }

    class Node{
        public int element;

        public Node right;
        public Node left;
        public Node top;
        public Node bottom;

        Node(int element){
            this.element = element;
            this.left = null;
            this.top = null;
            this.bottom = null;
            this.right = null;
        }

        Node(Node node){
            this.element = node.element;
            this.left = null;
            this.top = null;
            this.right = null;
            this.bottom = node;
        }
    }

    public static void main( String[] args ) {
        SkipList list = new SkipList();
        list.insert(5);
        list.insert(10);
        list.insert(9);
        list.insert(8);
        list.insert(12);
        list.insert(1);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(90);

        System.out.println(list.toString());

        list.delete(10);
        list.delete(1);
        System.out.println(list.toString());
    }
}