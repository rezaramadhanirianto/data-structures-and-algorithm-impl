package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

public class SelectionSort implements Sort{
    @Override
    public void sort(int[] values) {
        SelectionSort.selectionSort(values);
    }

    public static void selectionSort(int[] values){
        for(int i = 0; i < values.length; i++){
            int smallest = i;
            for(int j = i; j < values.length; j++){
                if(values[j] < values[smallest]){
                    smallest = j;
                }
            }

            if(smallest != values[i]){
                swap(values, smallest, i);
            }
        }
    }

    public static void swap(int[] values, int i, int j){
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 23, 4, 2 ,5, 1};
        SelectionSort sorter = new SelectionSort();
        sorter.sort(array);
        // Prints:
        // [1, 2, 4, 5, 12, 23]
        System.out.println(java.util.Arrays.toString(array));
    }
}
