package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

import com.rezaramadhanirianto.dsaImpl.datastructures.graph.WeightedGraph;
import com.rezaramadhanirianto.dsaImpl.datastructures.graph.WeightedGraphEdge;

import java.util.*;

public class DijkstraPriorityQueue {
    public static double[] dijkstra(WeightedGraph graph, int n, int start)
    {
        PriorityQueue<WeightedGraphEdge> pq = new PriorityQueue<>((o1, o2) -> (int) ((int) o1.cost - o2.cost));

        double[] dist = new double[n];
        Set<Integer> visited = new HashSet();
        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        pq.add(new WeightedGraphEdge(start, 0));
        dist[start] = 0.0;

        while (!pq.isEmpty()) {
            WeightedGraphEdge node = pq.poll();
            if(!visited.add(node.node)) continue;
            // we found better path before processing
            if(node.cost > dist[node.node]) continue;
            dist[node.node] = node.cost;

            for(WeightedGraphEdge edge: graph.data[node.node]){
                if(visited.contains(edge.node)) continue;

                for(WeightedGraphEdge next: graph.data[node.node]){
                    if(!visited.contains(next.node))
                        pq.add(new WeightedGraphEdge(next.node, next.cost + node.cost));
                }
            }
        }

        return dist;
    }

    public static void main(String args[]){
        WeightedGraph graph = new WeightedGraph(7);
        graph.addEdge(0, 1, 22);
        graph.addEdge(1, 3, 1);
        graph.addEdge(0, 3, 28);
        graph.addEdge(3, 4, 61);
        graph.addEdge(2, 4, 21);
        graph.addEdge(2, 3, 73);
        graph.addEdge(0, 2, 36);
        graph.addEdge(0, 4, 18);
        graph.addEdge(1, 4, 26);
        graph.addEdge(1, 2, 37);

        double[] output = dijkstra(graph, 5, 0);
        System.out.println(Arrays.toString(output));
    }
}
