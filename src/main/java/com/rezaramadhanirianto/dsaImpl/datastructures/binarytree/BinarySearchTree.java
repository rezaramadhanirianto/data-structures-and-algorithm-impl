package com.rezaramadhanirianto.dsaImpl.datastructures.binarytree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {
    private int node = 0;
    private Node root;

    class Node{
        T data;
        Node left, right;

        Node(Node left, Node right,T data){
            this.left = left;
            this.right = right;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int size(){
        return node;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    // TODO: Add Public
    public boolean add(T elem){
        if(contains(elem)){
            return false;
        }else{
            root = add(root, elem);
            node++;
            return true;
        }
    }
    // TODO: Add private
    private Node add(Node node, T elem){
        if(node == null){
            node = new Node(null, null, elem);
        }else{
            if(elem.compareTo(node.data) > 0){
                node.right = add(node.right, elem);
            }else{
                node.left = add(node.left, elem);
            }
        }
        return node;
    }
    // TODO: Remove Public
    public boolean remove(T elem){
        if(!contains(elem)) return false;
        else {
            root = remove(root, elem);
            node--;
            return true;
        }
    }

    private Node remove(Node node, T elem) {
        if(node == null) return null;

        int cmp = elem.compareTo(node.data);
        if(cmp > 0){
            node.right = remove(node.right, elem);
        }else if(cmp < 0){
            node.left = remove(node.left, elem);
        }else{
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            else{
                Node temp = findMind(node.right);
                node.data = temp.data;

                node.right = remove(node.right, temp.data);
            }
        }
        return node;
    }

    private Node findMind(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    // TODO: Contains Public
    public boolean contains(T elem){
        return contains(root, elem);
    }

    // TODO: contains private
    private boolean contains(Node node, T elem) {
        if(node == null) return false;

        int cmp = elem.compareTo(node.data);
        if(cmp > 0)
            return contains(node.right, elem);
        else if(cmp < 0)
            return contains(node.left, elem);
        else
            return true;
    }

    // Computes the height of the tree, O(n)
    public int height() {
        return height(root);
    }

    // Recursive helper method to compute the height of the tree
    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public Iterator<T> traverse(TraversalOrder order){
        switch (order){
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }
    // TODO: PreOrder
    public Iterator<T> preOrderTraversal(){
        final int expectedNodeCount = node;
        final Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != node) throw new ConcurrentModificationException();
                return root != null && !stack.empty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != node) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
                return node.data;
            }
        };
    }

    // TODO: InOrder
    public Iterator<T> inOrderTraversal() {
        final int expectedNodeCount = node;
        final Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        return new Iterator<T>() {
            Node trav = root;
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != node) throw new ConcurrentModificationException();
                return root != null && !stack.empty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != node) throw new ConcurrentModificationException();
                while(trav != null && trav.left != null){
                    stack.push(trav.left);
                    trav = trav.left;
                }
                Node node = stack.pop();

                // Try moving down right once
                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }

                return node.data;
            }
        };
    }

    // TODO: PostOrder
    public Iterator<T> postOrderTraversal(){
        final int expectedNodeCount = node;
        final Stack<Node> stack1 = new Stack<Node>();
        final Stack<Node> stack2 = new Stack<Node>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node node = stack1.pop();
            if(node != null){
                stack2.push(node);
                if(node.left != null) stack1.push(node.left);
                if(node.right != null) stack1.push(node.right);
            }
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != node) throw new ConcurrentModificationException();
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != node) throw new ConcurrentModificationException();
                return stack2.pop().data;
            }
        };
    }

    // Returns as iterator to traverse the tree in level order
    public java.util.Iterator<T> levelOrderTraversal() {

        final int expectedNodeCount = node;
        final java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != node) throw new java.util.ConcurrentModificationException();
                return root != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != node) throw new java.util.ConcurrentModificationException();
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        return "BinarySearchTree{root=" + root.toString() + '}';
    }

    enum TraversalOrder{
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER,
    }
}
