package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

public class DeepFirstSearch extends Graph{
    DeepFirstSearch(int size) {
        super(size);
    }

    void DFS(int s, boolean[] visited){
        visited[s] = true;

        System.out.print(s + " ");

        for(int n: adj[s]){
            if(!visited[n]){
                DFS(n, visited);
            }
        }
    }

    public static void main(String args[])
    {
        DeepFirstSearch g = new DeepFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(0, new boolean[g.size]);
    }
}
