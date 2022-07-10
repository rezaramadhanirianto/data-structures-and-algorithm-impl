package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] arr){
        if (arr == null) return;
        int n = arr.length;

        // Heapify, converts array into binary heap O(n), see:
        // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
        for (int i = (n / 2) - 1; i >= 0; i--) {
            sink(arr, n, i);
        }

        // Sorting bit
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            sink(arr, i, 0);
        }
    }

    private void sink(int[] arr, int n, int i){
        while(true){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            // Right child is larger than parent
            // if right > n do nothing cuz it will be mess up our heap
            if (right < n && arr[right] > arr[largest]) largest = right;

            // Left child is larger than parent
            // if left > n do nothing cuz it will be mess up our heap
            if (left < n && arr[left] > arr[largest]) largest = left;

            if(largest != i){
                swap(arr, largest, i);
                i = largest;
            } else break;
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static void main(String[] args){
        HeapSort sorter = new HeapSort();
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        sorter.sort(array);
        // Prints:
        // [-13, 2, 3, 4, 4, 6, 8, 10]
        System.out.println(java.util.Arrays.toString(array));
    }
}
