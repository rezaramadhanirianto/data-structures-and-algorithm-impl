package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

import java.util.*;

class TopologicalSort {


    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean[] visited,
                             Stack<Integer> stack, Graph graph)
    {
        // Mark the current node as visited.
        visited[v] = true;

        // Recur for all the vertices adjacent
        // to this vertex
        for (Integer num : graph.adj[v]) {
            if (!visited[num]) topologicalSortUtil(num, visited, stack, graph);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    void topologicalSort(Graph graph)
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.size];

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < graph.size; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, graph);

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    // Driver code
    public static void main(String[] args)
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);


        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.topologicalSort(g);
    }
}



