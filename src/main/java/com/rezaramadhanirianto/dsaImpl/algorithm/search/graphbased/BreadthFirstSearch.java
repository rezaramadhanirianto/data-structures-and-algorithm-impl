package com.rezaramadhanirianto.dsaImpl.algorithm.search.graphbased;

import java.util.LinkedList;

public class BreadthFirstSearch extends Graph{
    public BreadthFirstSearch(int size) {
        super(size);
    }

    public void BFS(int s){
        boolean[] visited = new boolean[size];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0){
            s = queue.poll();

            System.out.print(s + " ");

            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[])
    {
        BreadthFirstSearch g = new BreadthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 1)");

        g.BFS(0);
    }
}
