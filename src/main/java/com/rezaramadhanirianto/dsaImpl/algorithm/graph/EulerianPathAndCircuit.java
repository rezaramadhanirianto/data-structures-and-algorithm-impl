package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

import java.util.*;

class EulerianPathAndCircuit {
    // Utility function to perform DFS traversal on the graph
    public static void DFS(Graph graph, int node, Set<Integer> visited) {
        // mark the current node as discovered
        visited.add(node);
        for (int next : graph.adjList.get(node)) {
            if (!visited.contains(next)) {
                DFS(graph, next, visited);
            }
        }
    }

    // Function to check if all vertices with a non-zero degree in a graph
    public static boolean isConnected(Graph graph, int n) {
        // to keep track of whxether a vertex is visited or not
        Set<Integer> visited = new HashSet<>();

        // start DFS from the first vertex with a non-zero degree
        for (int i = 0; i < n; i++) {
            if (graph.adjList.get(i).size() > 0) {
                DFS(graph, i, visited);
                break;
            }
        }

        // if a single DFS call couldn't visit all vertices with a non-zero degree,
        // the graph contains more than one connected component
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i) && graph.adjList.get(i).size() > 0) {
                return false;
            }
        }
        return true;
    }

    // Utility function to return the total number of vertices in a graph
    // with an odd degree
    public static int countOddVertices(Graph graph) {
        int count = 0;
        for (List<Integer> list : graph.adjList) {
            System.out.println(list);
            if ((list.size() & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        // undirected graph
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(0).add(3);
        list.get(3).add(0);
        list.get(1).add(2);
        list.get(2).add(1);
        list.get(1).add(3);
        list.get(3).add(1);
        list.get(1).add(4);
        list.get(4).add(1);
        list.get(2).add(3);
        list.get(3).add(2);
        list.get(3).add(4);
        list.get(4).add(3);
        Graph graph = new Graph(list);
        boolean isConnected = isConnected(graph, n);
        int odd = countOddVertices(graph);
        if (isConnected && (odd == 0 || odd == 2)) {
            System.out.println("The graph has an Eulerian path");
            if (odd == 0) {
                System.out.println("The graph has an Eulerian cycle");
            } else {
                System.out.println("The Graph is Semi–Eulerian");
            }
        } else {
            System.out.println("The Graph is not Eulerian");
        }
    }

    static class Graph {
        List<List<Integer>> adjList;
        Graph(List<List<Integer>> edges) {
            adjList = edges;
        }
    }
}
