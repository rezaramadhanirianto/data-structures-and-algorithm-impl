package com.rezaramadhanirianto.dsaImpl.datastructures.graph;

import java.util.*;

public class Graph {
    public int size;
    public Map<Integer, List<Integer>> data;

    public Graph(int size){
        this.size = size;
        data = new HashMap<>();
        for(int i = 0; i < size; i++)
            data.put(i, new ArrayList<>());
    }

    public void addEdge(int key, int value){
        data.get(key).add(value);
    }
}
