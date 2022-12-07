package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

import com.rezaramadhanirianto.dsaImpl.datastructures.graph.WeightedGraph;
import com.rezaramadhanirianto.dsaImpl.datastructures.graph.WeightedGraphEdge;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    public static double[] bellmanFord(WeightedGraph graph, int n, int start){
        double[] output = new double[n];
        Arrays.fill(output, Double.POSITIVE_INFINITY);
        output[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n; j++){
                List<WeightedGraphEdge> edges = graph.data[j];
                for(WeightedGraphEdge edge: edges){
                    if(output[j] + edge.cost < output[edge.node]){
                        output[edge.node] = output[j] + edge.cost;
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n; j++){
                List<WeightedGraphEdge> edges = graph.data[j];
                for (WeightedGraphEdge edge : edges) {
                    if (output[j] + edge.cost < output[edge.node]) output[edge.node] = Double.NEGATIVE_INFINITY;
                }
            }
        }

        return output;
    }

    public static void main(String args[])
    {
        int n = 9;
        WeightedGraph graph = new WeightedGraph(n);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(4, 3, -3);
        graph.addEdge(3, 2, 1);
        graph.addEdge(1, 5, 4);
        graph.addEdge(1, 6, 4);
        graph.addEdge(5, 6, 5);
        graph.addEdge(6, 7, 4);
        graph.addEdge(5, 7, 3);
        double[] d = bellmanFord(graph, n, 0);
        System.out.println(Arrays.toString(d));
    }
}
