package com.rezaramadhanirianto.dsaImpl.algorithm.graph.euler;

import java.util.*;

public class Hierholzer {
    public static void hierholzer(LinkedList<LinkedList<Integer>> graph){
        LinkedList<Integer> res = new LinkedList<>();
        if (graph.size() == 0) {
            System.out.println("Result: " + res);
            return;
        }
        helper(0, graph, res);
        System.out.println("Result: " + res);
    }

    static void helper(int node, LinkedList<LinkedList<Integer>> graph, LinkedList<Integer> res){
        while(graph.get(node).peek() != null){
            int next = graph.get(node).getLast();
            graph.get(node).removeLast();
            helper(next, graph, res);
        }

        res.addFirst(node);
    }

    public static void main(String[] args) {
        // Input Graph 1
        LinkedList<LinkedList<Integer>> adj1 = new LinkedList<>();
        adj1.add(new LinkedList<Integer>());
        adj1.add(new LinkedList<Integer>());
        adj1.add(new LinkedList<Integer>());
        adj1.get(0).add(1);
        adj1.get(1).add(2);
        adj1.get(2).add(0);
        hierholzer(adj1);

        // Input Graph 2
        LinkedList<LinkedList<Integer>> adj2 = new LinkedList<>();
        adj2.add(new LinkedList<Integer>());
        adj2.add(new LinkedList<Integer>());
        adj2.add(new LinkedList<Integer>());
        adj2.add(new LinkedList<Integer>());
        adj2.add(new LinkedList<Integer>());
        adj2.add(new LinkedList<Integer>());
        adj2.add(new LinkedList<Integer>());
        adj2.get(0).add(1);
        adj2.get(0).add(6);
        adj2.get(1).add(2);
        adj2.get(2).add(0);
        adj2.get(2).add(3);
        adj2.get(3).add(4);
        adj2.get(4).add(2);
        adj2.get(4).add(5);
        adj2.get(5).add(0);
        adj2.get(6).add(4);
        hierholzer(adj2);
    }
}
// [0, 1, 2, 0]
// [[1, 6], [2], [0, 3], [4], [2, 5], [0], [4]]
// [0, 1, 2, 0, 6, 4, 2, 3, 4, 5, 0]

// 0 -> 1 -> 2 -> 0
// [[1, 6], [2], [0, 3], [4], [2, 5], [0], [4]]
// 0 -> 6 -> 4 -> 5 -> 0 -> 1 -> 2 -> 3 -> 4 -> 2 -> 0