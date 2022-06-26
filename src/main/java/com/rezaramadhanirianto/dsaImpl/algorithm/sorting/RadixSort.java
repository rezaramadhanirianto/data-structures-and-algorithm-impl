package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

public class RadixSort implements Sort {
    @Override
    public void sort(int[] values) {
        radixSort(values);
    }

    private void radixSort(int[] values){
        int max = getMax(values);
        int digit = calculateNumberOfDigit(max);
        int placeValue = 1;
        while(digit-- > 0){
            countingSort(values, placeValue);
            placeValue *= 10;
        }
    }

    private void countingSort(int[] values, int placeValue){
        int range = 10;

        int[] frequency = new int[range];
        int[] sortedValues = new int[values.length];

        for (int value : values) {
            int digit = (value / placeValue) % range;
            frequency[digit]++;
        }

        for(int i = 1; i < range; i++){
            frequency[i] += frequency[i - 1];
        }

        for(int i = values.length - 1; i >= 0; i--){
            int digit = (values[i] / placeValue) % range;
            sortedValues[--frequency[digit]] = values[i];
        }

        System.arraycopy(sortedValues, 0, values, 0, values.length);
    }

    private int getMax(int[] values){
        int max = values[0];
        for(int i = 0; i < values.length; i++){
            if(values[i] > max) max = values[i];
        }
        return max;
    }

     int calculateNumberOfDigit(int number){
        return (int) Math.log10(number) + 1;
    }

    public static void main(String[] args){
        int[] array = {3, 2, 1, 5, 6 ,4};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
