package com.rezaramadhanirianto.dsaImpl.algorithm.graph;

class FloydWarshall {
    final static int INF = 9999;

    void floydWarshall(int[][] graph, int n) {
        int[][] matrix = new int[n][n];
        int i, j, k;

        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                matrix[i][j] = graph[i][j];

        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
        printMatrix(matrix, n);
    }

    void printMatrix(int matrix[][], int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph, 4);
    }
}