package com.rezaramadhanirianto.dsaImpl.datastructures.balancedtree;

import com.rezaramadhanirianto.dsaImpl.datastructures.utils.TreePrinter;
import java.util.Iterator;
import java.util.function.Consumer;


/*
* Under Construction
* */
public class AVLTree<T extends Comparable<T>> implements Iterable<T> {

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

    public boolean remove(T elem){
        if(elem == null) return false;
        if(contains(root, elem)){
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {
        if (node == null) return null;

        int cmp = elem.compareTo(node.value);
        // Dig into left subtree, the value we're looking
        // for is smaller than the current value.
        if (cmp < 0) {
            node.left = remove(node.left, elem);

            // Dig into right subtree, the value we're looking
            // for is greater than the current value.
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);

            // Found the node we wish to remove.
        } else {

            // This is the case with only a right subtree or no subtree at all.
            // In this situation just swap the node we wish to remove
            // with its right child.
            if (node.left == null) {
                return node.right;

                // This is the case with only a left subtree or
                // no subtree at all. In this situation just
                // swap the node we wish to remove with its left child.
            } else if (node.right == null) {
                return node.left;

                // When removing a node from a binary tree with two links the
                // successor of the node being removed can either be the largest
                // value in the left subtree or the smallest value in the right
                // subtree. As a heuristic, I will remove from the subtree with
                // the greatest height in hopes that this may help with balancing.
            } else {

                // Choose to remove from left subtree
                if (node.left.height > node.right.height) {

                    // Swap the value of the successor into the node.
                    T successorValue = findMax(node.left);
                    node.value = successorValue;

                    // Find the largest node in the left subtree.
                    node.left = remove(node.left, successorValue);

                } else {

                    // Swap the value of the successor into the node.
                    T successorValue = findMin(node.right);
                    node.value = successorValue;

                    // Go into the right subtree and remove the leftmost node we
                    // found and swapped data with. This prevents us from having
                    // two nodes in our tree with the same value.
                    node.right = remove(node.right, successorValue);
                }
            }
        }

        // Update balance factor and height values.
        update(node);

        // Re-balance tree.
        return balance(node);
    }

    // Helper method to find the leftmost node (which has the smallest value)
    private T findMin(Node node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    // Helper method to find the rightmost node (which has the largest value)
    private T findMax(Node node) {
        while (node.right != null) node = node.right;
        return node.value;
    }

    // Returns as iterator to traverse the tree in order.
    public java.util.Iterator<T> iterator() {

        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();

                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }

                return node.value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        return TreePrinter.getTreeDisplay(root);
    }

    // Make sure all left child nodes are smaller in value than their parent and
    // make sure all right child nodes are greater in value than their parent.
    // (Used only for testing)
    public boolean validateBSTInvarient(Node node) {
        if (node == null) return true;
        T val = node.value;
        boolean isValid = true;
        if (node.left != null) isValid = isValid && node.left.value.compareTo(val) < 0;
        if (node.right != null) isValid = isValid && node.right.value.compareTo(val) > 0;
        return isValid && validateBSTInvarient(node.left) && validateBSTInvarient(node.right);
    }
}


