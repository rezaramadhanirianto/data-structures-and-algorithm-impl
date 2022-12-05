package com.rezaramadhanirianto.dsaImpl.algorithm.graph.topologicalsort;

import com.rezaramadhanirianto.dsaImpl.datastructures.graph.Graph;

import java.util.LinkedList;

public class TopologicalSortDFS {
    private static int dfs(LinkedList<Integer> list, int i, int node, boolean[] visited, int[] ordering, Graph graph) {
        visited[node] = true;
        for (Integer neighbor : graph.data.get(node)){
            if (!visited[neighbor])
                i = dfs(list, i, neighbor, visited, ordering, graph);
        }

        list.addFirst(node);
        ordering[i] = node;
        return i - 1;
    }

    public static int[] topologicalSort(Graph graph, int n) {
        // we can use stack instead of array
        LinkedList<Integer> list = new LinkedList<>();
        int[] ordering = new int[n];
        boolean[] visited = new boolean[n];

        int i = n - 1;
        for (int j = 0; j < n; j++)
            if (!visited[j]) i = dfs(list, i, j, visited, ordering, graph);

        list.forEach(data -> {
            System.out.print(data + " ");
        });

        return ordering;
    }

    public static void main(String[] args) {

        final int N = 6;
        Graph graph = new Graph(N);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(2, 3);
        int[] ordering = topologicalSort(graph, N);

        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        System.out.println(java.util.Arrays.toString(ordering));
    }

}
