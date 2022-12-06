package com.rezaramadhanirianto.dsaImpl.algorithm.greedy;


import java.util.Arrays;
// Dijkstra / Shortest Path
// from my POV, Dijkstra Algorithm is check node based on possible edges should be
// ex: 1 -> 2 -> 3
// we check 1 by 1
// check is there edges 1 -> 3 ?
// check is there edges 2 -> 3 ?
// if there's add to array helper of index 3 minimum value
public class Dijkstra {
    void dijkstra(int[][] graph, int start){
        int count = graph.length;
        boolean[] visitedVertex = new boolean[count];
        int[] track = new int[count];
        for(int i = 0; i < count; i++){
            visitedVertex[i] = false;
            track[i] = Integer.MAX_VALUE;
        }

        track[start] = 0;
        for (int i = 0; i < count; i++) {
            int indexMinimum = findMin(track, visitedVertex);
            visitedVertex[indexMinimum] = true;

            for (int j = 0; j < count; j++) {
                // handle already visited         handle start                            check next
                if(!visitedVertex[j] && graph[indexMinimum][j] != 0 && (track[indexMinimum] + graph[indexMinimum][j] < track[j])){
                    track[j] = track[indexMinimum] + graph[indexMinimum][j];
                }
            }
        }

        for (int i = 0; i < track.length; i++) {
            System.out.printf("Distance from %s to %s is %s%n", start, i, track[i]);
        }
    }

    int findMin(int[] track, boolean[] visitedVertex){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < track.length; i++){
            if(!visitedVertex[i] && track[i] < min){
                min = track[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String args[]){
        int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
        Dijkstra T = new Dijkstra();
        T.dijkstra(graph, 0);
    }
}
