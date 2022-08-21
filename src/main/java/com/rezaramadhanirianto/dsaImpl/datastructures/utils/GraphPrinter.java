package com.rezaramadhanirianto.dsaImpl.datastructures.utils;

// O(N³)
public class GraphPrinter {
    public void print(int root, int[] data){
        printAllLevel(data, root);
    }

    // n^3
    public void printAllLevel(int[] data, int root){
        int maxLevel = maxLevel(data, root); // n^2
        for(int i = 1; i <= maxLevel; i++){ // n
            printlnCurrentLevel(data, root, i); // n^2
        }
    }

    // O(N^2)
    public void printlnCurrentLevel(int[] data, int root, int level){
        for(int i = 0; i< data.length; i++){ // n^2
            if(countLevel(data, root, i) == level){ // n
                System.out.print(data[i] + " -> " + i + ", ");
            }
        }
        System.out.println();
    }

    // O(N^2)
    public int maxLevel(int[] data, int root){
        int max = 0;
        for(int i = 0; i < data.length; i++){
            max = Math.max(max, countLevel(data, root, i));
        }
        return max;
    }

    // O(N)
    public int countLevel(int[] data, int root, int val){
        int count = 1;
        while(val != root){
            val = data[val];
            count++;
        }
        return count;
    }
}
