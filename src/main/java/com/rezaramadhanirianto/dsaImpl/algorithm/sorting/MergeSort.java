package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

public class MergeSort implements Sort{
    public static int[] mergesort(int[] sort){
        if(sort.length < 2) return sort;

        int size = sort.length;
        int sizeLeft = size / 2;
        int sizeRight = size - sizeLeft;
        int[] left = new int[sizeLeft];
        int[] right = new int[sizeRight];

        for(int i = 0; i < sizeLeft; i++){
            left[i] = sort[i];
        }

        for(int j = 0; j < sizeRight; j++){
            right[j] = sort[j + sizeLeft];
        }


        var left2 = mergesort(left);
        var right2 = mergesort(right);

        return merge(left2, right2);
    }

    private static int[] merge(int[] left, int[] right) {
        int leftSize = left.length, rightSize = right.length;
        int size = leftSize + rightSize, i = 0, j = 0;
        int[] arr = new int[size];

        for(int k = 0; k < size; k++){
            if(i >= leftSize){
                arr[k] = right[j++];
            }else if(j >= rightSize){
                arr[k] = left[i++];
            }else{
                if(left[i] < right[j]){
                    arr[k] = left[i++];
                }else{
                    arr[k] = right[j++];
                }
            }
        }

        return arr;

    }


    @Override
    public void sort(int[] values) {
        int[] sorted = mergesort(values);
        for(int i = 0; i < values.length; i++){
            values[i] = sorted[i];
        }
    }

    public static void main(String[] args){
        int[] array = {12, 23, 4, 2 ,5, 1};
        MergeSort sorter = new MergeSort();
        sorter.sort(array);
        // Prints:
        System.out.println(java.util.Arrays.toString(array));
    }
}
