package com.rezaramadhanirianto.dsaImpl.algorithm.graph.topologicalsort;

import com.rezaramadhanirianto.dsaImpl.datastructures.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kahn Algorithm
public class TopologicalSortBFS {
    private static List<Integer> bfs(Graph graph, int n){
        List<Integer> output = new ArrayList<>();
        int[] requirement = new int[n];

        for(int i = 0; i < n;i++) {
            for(Integer it: graph.data.get(i)) {
                requirement[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n;i++)
            if(requirement[i] == 0) q.add(i);

        int size = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            output.add(node);
            for(Integer neighbor: graph.data.get(node)) {
                size++;
                if(--requirement[neighbor] == 0) q.add(neighbor);
            }
        }

        System.out.println("Can Finish: " + (size == n));
        return output;
    }

    // Example usage of topological sort
    public static void main(String[] args) {

        // Graph setup
        final int N = 6;
        Graph graph = new Graph(N);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(2, 3);
        List<Integer> output = bfs(graph, N);

        // // Prints: [6, 0, 5, 1, 2, 3, 4]
        System.out.println(output);
    }
}
