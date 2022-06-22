package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

public class QuickSort implements Sort{
    @Override
    public void sort(int[] values) {
        QuickSort.quickSort(values, 0, values.length - 1);
    }

    public static int partition(int[] values, int low, int high){
        int pivot = high;

        int i = (low - 1);

        for(int j = low; j < high; j++){
            if(values[j] <= values[pivot]){
                i++;

                int temp = values[j];
                values[j] = values[i];
                values[i] = temp;
            }
        }

        int temp = values[i+1];
        values[i+1] = values[high];
        values[pivot] = temp;
        return ( i + 1 );
    }

    public static void quickSort(int[] values, int low, int high){
        if(low < high){
            int pivot = partition(values, low, high);

            quickSort(values, low, pivot - 1);
            quickSort(values, pivot + 1, high);
        }
    }

    public static void main(String[] args){
        int[] array = {12, 23, 4, 2 ,5, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(array);
        // Prints:
        System.out.println(java.util.Arrays.toString(array));
    }
}
