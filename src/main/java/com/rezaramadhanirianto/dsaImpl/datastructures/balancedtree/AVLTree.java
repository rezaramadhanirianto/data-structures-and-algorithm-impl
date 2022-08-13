package com.rezaramadhanirianto.dsaImpl.datastructures.balancedtree;

import com.rezaramadhanirianto.dsaImpl.datastructures.utils.TreePrinter;
import java.util.Iterator;
import java.util.function.Consumer;


/*
* Under Construction
* */
public class AVLTree<T extends Comparable<T>> implements Iterator<T> {

    public class Node implements TreePrinter.PrintableNode{
        public int balanceFactor;

        public T value;

        public int height;

        public Node left, right;

        public Node(T value){
            this.value = value;
        }

        @Override
        public Node getLeft() {
            return left;
        }

        @Override
        public Node getRight() {
            return right;
        }

        @Override
        public String getText() {
            return value.toString();
        }
    }

    public Node root;

    private int nodeCount;

    public int height(){
        if(root == null) return 0;
        return root.height;
    }

    public int size(){
        return nodeCount;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(T value){
        return contains(root, value);
    }

    public boolean contains(Node node, T value){
        if(node == null) return false;

        int cmp = value.compareTo(node.value);

        if(cmp < 0) return contains(node.left, value);
        if(cmp > 0) return contains(node.right, value);

        return true;
    }

    public boolean insert(T value){
        if(value == null) return false;
        if(!contains(root, value)){
            root = insert(root, value);
            nodeCount++;
            return true;
        }
        return false;
    }

    private Node insert(Node node, T value){
        if(node == null) return new Node(value);

        // Compare current value to the value in the node.
        int cmp = value.compareTo(node.value);

        // Insert node in left subtree.
        if (cmp < 0) {
            node.left = insert(node.left, value);

        // Insert node in right subtree.
        } else {
            node.right = insert(node.right, value);
        }

        update(node);

        return balance(node);
    }

    // Update a node's height and balance factor.
    private void update(Node node){
        int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
        int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

        // Update this node's height.
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node node){
        // Left heavy subtree.
        if (node.balanceFactor == -2) {

            // Left-Left case.
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);

                // Left-Right case.
            } else {
                return leftRightCase(node);
            }

            // Right heavy subtree needs balancing.
        } else if (node.balanceFactor == +2) {

            // Right-Right case.
            if (node.right.balanceFactor >= 0) {
                return rightRightCase(node);

                // Right-Left case.
            } else {
                return rightLeftCase(node);
            }
        }

        // Node either has a balance factor of 0, +1 or -1 which is fine.
        return node;
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        update(node);
        update(newParent);
        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        update(node);
        update(newParent);
        return newParent;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}


