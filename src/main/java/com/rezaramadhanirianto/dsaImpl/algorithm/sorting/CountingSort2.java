package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

// Google Engineer Implementation
public class CountingSort2 implements Sort{

    // find max and min in array
    @Override
    public void sort(int[] values) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int value : values) {
            if(value < minValue) minValue = value;
            if(value > maxValue) maxValue = value;
        }

        countingSort(values, minValue, maxValue);
    }

    private void countingSort(int[] values, int minValue, int maxValue){
        int size = maxValue - minValue + 1;
        int[] count = new int[size];

        // set count[i]++ if value found in values
        for (int value : values) count[value - minValue]++;


        // init again values from count array
        for(int i = 0, k = 0; i < size; i++){
            // this help if theres more than 1 number found in values
            while(count[i]-- > 0) values[k++] = i + minValue;
        }


    }

    public static void main(String[] args){
        int[] array = {3, 2, 1, -1, 5, 6 ,4};

        CountingSort2 countingSort = new CountingSort2();
        countingSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
