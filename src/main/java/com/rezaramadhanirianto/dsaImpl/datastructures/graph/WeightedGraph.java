package com.rezaramadhanirianto.dsaImpl.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    public List<WeightedGraphEdge>[] data;

    public WeightedGraph(int n){
        data = new ArrayList[n];
        for (int i = 0; i < n; i++){
            data[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, double cost){
        data[from].add(new WeightedGraphEdge(from, to, cost));
    }
}
