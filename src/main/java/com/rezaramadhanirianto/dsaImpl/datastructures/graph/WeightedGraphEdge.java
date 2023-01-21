package com.rezaramadhanirianto.dsaImpl.datastructures.graph;


public class WeightedGraphEdge implements Comparable<WeightedGraphEdge> {
    public double cost;
    public int node;

    public WeightedGraphEdge(int node, double cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(WeightedGraphEdge o) {
        return (int) (cost - o.cost);
    }
}