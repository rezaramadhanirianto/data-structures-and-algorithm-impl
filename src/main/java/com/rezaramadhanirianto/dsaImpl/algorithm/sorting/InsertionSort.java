package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

public class InsertionSort implements Sort{
    @Override
    public void sort(int[] values) {
        InsertionSort.insertionSort(values);
    }

    public static void insertionSort(int[] values){
        // google engineer solution
//        for(int i = 1; i < values.length; i++){
//            for(int j = i; j > 0 && values[j] < values[j - 1]; j--){
//                swap(values, j, j -1);
//            }
//        }

        // recursion solution
        for(int i = 1; i < values.length; i++){
            if(values[i] < values[i - 1]){
                swapUntilCorrect(values, i - 1, i);
            }
        }
    }

    private static void swapUntilCorrect(int[] values, int i, int j) {
        if(i < 0 || values[i] < values[j]) return;

        // swap
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        swapUntilCorrect(values, i - 1, j - 1);
    }

    private static void swap(int[] values, int i, int j) {
        // swap
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 23, 4, 2 ,5, 1};
        InsertionSort sorter = new InsertionSort();
        sorter.sort(array);
        // Prints:
        // [1, 2, 4, 5, 12, 23]
        System.out.println(java.util.Arrays.toString(array));
    }


}
