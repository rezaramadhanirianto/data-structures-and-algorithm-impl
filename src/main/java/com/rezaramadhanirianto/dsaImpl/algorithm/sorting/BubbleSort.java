package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

public class BubbleSort implements Sort{
    @Override
    public void sort(int[] values) {
        BubbleSort.bubbleSort(values);
    }

    private static void bubbleSort(int[] values){
        // google engineer solution
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i = 1; i < values.length; i++){
                // swap if the right side is smaller than left one swap
                // or simply if the right one is bigger than left one, swap it
                // if sorted = false run again
                if(values[i - 1] > values[i]){
                    swap(values, i -1, i);
                    sorted = false;
                }
            }
        }

//        // the simple one
//        for(int i = 0; i < values.length - 1; i++){
//            boolean sorted = true;
//            for(int j = 0; j < values.length - i - 1; j ++){
//                if(values[j] > values[j + 1]){
//                    swap(values, j, j+1);
//                    sorted = false;
//                }
//            }
//            if(sorted) break;
//        }
    }

    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 23, 4, 2 ,5, 1};
        BubbleSort sorter = new BubbleSort();
        sorter.sort(array);
        // Prints:
        // [2, 3, 4, 6, 8, 10, 13]
        System.out.println(java.util.Arrays.toString(array));
    }

}
