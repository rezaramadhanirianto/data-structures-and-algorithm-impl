package com.rezaramadhanirianto.dsaImpl.algorithm.greedy;

import com.rezaramadhanirianto.dsaImpl.datastructures.unionfind.UnionFind;
import com.rezaramadhanirianto.dsaImpl.datastructures.utils.GraphPrinter;

import java.util.Arrays;

public class KruskalAlgorithm {
    void kruskal(int graph[][], int n){
        int minCost = 0;

        UnionFind unionFind = new UnionFind(n);

        int edgeCount = 0;
        while(edgeCount < n -1){
            // x -> from vertex
            // y -> to vertex
            int min = Integer.MAX_VALUE, x = 0, y = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!unionFind.connected(i, j) && graph[i][j] != 0 && graph[i][j] < min){
                        min = graph[i][j];
                        x = i;
                        y = j;
                    }
                }
            }

            unionFind.unify(x,y);
            System.out.println(x + " - " + y + " : " + graph[x][y]);
            edgeCount++;
            minCost += min;
        }
        System.out.println("Minimum Cost: " +  minCost);
        GraphPrinter graphPrinter = new GraphPrinter();
        graphPrinter.print(unionFind.find(0), unionFind.getData());
    }

    public static void main(String[] args) {
        KruskalAlgorithm g = new KruskalAlgorithm();

        // number of vertices in graph
        int V = 6;

        // create a 2d array of size 5x5
        // for adjacency matrix to represent graph
        int[][] G = {
                {0, 1, 9, 0, 0, 14},
                {1, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0 ,0 , 6, 0, 9},
                {14, 0, 2, 0, 9, 0},
        };

        g.kruskal(G, V);

    }
}
