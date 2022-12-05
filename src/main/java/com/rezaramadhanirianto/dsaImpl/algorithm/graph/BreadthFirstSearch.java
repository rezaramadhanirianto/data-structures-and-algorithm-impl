package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

import com.rezaramadhanirianto.dsaImpl.datastructures.graph.Graph;

import java.util.LinkedList;

public class BreadthFirstSearch{
    public static void BFS(Graph graph, int node){
        boolean[] visited = new boolean[graph.size];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);
        while(queue.size() != 0){
            node = queue.poll();

            System.out.print(node + " ");

            for (int n : graph.data.get(node)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[])
    {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 1)");

        BFS(graph,0);
    }
}
