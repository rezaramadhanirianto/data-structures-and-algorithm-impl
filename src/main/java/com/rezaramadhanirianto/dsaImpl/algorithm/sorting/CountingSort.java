package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

public class CountingSort implements Sort{
    @Override
    public void sort(int[] values) {
        CountingSort.countSort(values);
    }

    private static void countSort(int[] values){
        int[] output = new int[values.length];

        int max = 0;
        for (int value : values) {
            if (value > max) max = value;
        }

        // we need to + 1 to handle value max of element
        // example: array[6]
        // if size is 6 it would be index out of bond
        int[] count = new int[(max) + 1];

        for (int value : values) {
            count[value]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }

        for(int i = output.length - 1; i >= 0; i--){
            output[count[values[i]] - 1] = values[i];
            count[values[i]]--;
        }

        for (int i = 0; i < output.length; i++){
            values[i] = output[i];
        }
    }

    public static void main(String[] args){
        int[] array = {3, 2, 1, 5, 6 ,4};

        CountingSort countingSort = new CountingSort();
        countingSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
