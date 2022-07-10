package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] arr){
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int ar : arr){
            if(ar < minValue) minValue = ar;
            if(ar > maxValue) maxValue = ar;
        }


        bucketSort(arr, maxValue, minValue);
    }

    private void bucketSort(int[] arr, int maxValue, int minValue){
        // N is number elements and M is the range of values
        // M / N + 1 is for create less array to make faster
        final int N = arr.length, M = maxValue - minValue + 1, numBuckets = M / N + 1;

        List<List<Integer>> buckets = new ArrayList<>(numBuckets);
        for(int i = 0; i < numBuckets; i++) buckets.add(new ArrayList<>());

        for(int i = 0; i < N; i++){
            int bi = (arr[i] - minValue) / N;
            List<Integer> bucket = buckets.get(bi);
            bucket.add(arr[i]);
        }

        for(int bi = 0, i = 0; bi < numBuckets; bi++){
            List<Integer> bucket = buckets.get(bi);
            if(bucket != null){
                Collections.sort(bucket);
                for(int k = 0; k < bucket.size(); k++){
                    arr[i++] = bucket.get(k);
                }
            }
        }
    }

    public static void main(String[] args){
        BucketSort sorter = new BucketSort();

        int[] array = {10, 4, 6, 8, 13, 2, 3, 200};
        sorter.sort(array);
        // Prints:
        // [2, 3, 4, 6, 8, 10, 13]
        System.out.println(java.util.Arrays.toString(array));

        array = new int[] {10, 10, 10, 10, 10};
        sorter.sort(array);
        // Prints:
        // [10, 10, 10, 10, 10]
        System.out.println(java.util.Arrays.toString(array));
    }
}
