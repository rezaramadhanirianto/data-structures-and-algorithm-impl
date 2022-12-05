package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

import com.rezaramadhanirianto.dsaImpl.datastructures.graph.Graph;

public class DeepFirstSearch{
    static void DFS(Graph graph, int node, boolean[] visited){
        visited[node] = true;

        System.out.println(node);
        for(int n: graph.data.get(node)){
            if(!visited[n]){
                DFS(graph, n, visited);
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
        graph.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        DFS(graph, 0, new boolean[graph.size]);
    }
}
