package com.rezaramadhanirianto.dsaImpl.algorithm.search.graphbased;

import java.util.LinkedList;

public class Graph {
    protected int size;
    protected LinkedList<Integer> adj[];

    Graph(int size){
        this.size = size;
        adj = new LinkedList[size];
        for(int i = 0; i < size; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }


}
