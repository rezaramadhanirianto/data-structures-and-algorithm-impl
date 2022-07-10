package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

public class ShellSort {
    void sort(int array[]){
        shellSort(array, array.length);
    }
    // Rearrange elements at each n/2, n/4, n/8, ... intervals
    void shellSort(int arr[], int n) {
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i ++)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j - gap];
                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = { 2, 3, 1, 5, 4, 0 };
        int size = data.length;
        ShellSort ss = new ShellSort();
        ss.shellSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
