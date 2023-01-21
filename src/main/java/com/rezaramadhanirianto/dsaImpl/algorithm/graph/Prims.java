package com.rezaramadhanirianto.dsaImpl.algorithm.graph;// Prim's Algorithm in Java

import java.util.Arrays;

// this used adjacency matrix
class Prims {
    public void Prim(int G[][], int V){
        int INFINITY = Integer.MAX_VALUE;

        // number of edge
        int noEdge = 0;

        // create array to track selected vertex
        boolean[] selected = new boolean[V];

        Arrays.fill(selected, false);

        // let's select vertex 0 first
        selected[0] = true;

        // set V - 1 because we already got the first vertex
        while(noEdge < V -1){
            int min = INFINITY;
            int x = 0;
            int y = 0;

            for(int i = 0; i < V; i++){
                // if we haven't tracked the edge let's skip this edge
                if(!selected[i]) continue;
                for(int j = 0; j < V; j++){
                    // find minimum edge and we haven't visited yet
                    if(!selected[j] && G[i][j] != 0){
                        if(min > G[i][j]){
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " : " + G[x][y]);
            selected[y] = true;
            noEdge++;
        }
    }
    public static void main(String[] args) {
        Prims g = new Prims();

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

        g.Prim(G, V);
    }
}