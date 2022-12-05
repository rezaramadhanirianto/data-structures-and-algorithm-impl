package com.rezaramadhanirianto.dsaImpl.datastructures.graph;


public class WeightedGraphEdge {
    public double cost;
    public int from, to;

    public WeightedGraphEdge(int from, int to, double cost) {
        this.to = to;
        this.from = from;
        this.cost = cost;
    }
}