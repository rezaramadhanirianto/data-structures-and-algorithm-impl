package com.rezaramadhanirianto.dsaImpl.algorithm.sorting;

import java.util.Arrays;

public class QuickSort implements Sort{
    @Override
    public void sort(int[] values) {
        QuickSort.quickSort(values, 0, values.length - 1);
    }

    public static int partition(int[] values, int low, int high){
//        Google Engineer Implementation
//        With Hoare Partition
//        Basically this algorithm is find place partition that right side is greater than pivot
//        and the left side is smaller than pivot
//        the pivot candidate is j, witches this pivot candidate is find the smaller than pivot from the right side cuz the right side is the bigger list of number
//        int pivot = values[low];
//        int i = low - 1, j = high + 1;
//        while (true) {
//            do {
//                i++;
//            } while (values[i] < pivot);
//            do {
//                j--;
//            } while (values[j] > pivot);
//            if (i < j) {
//                System.out.println(i + " " + j);
//                swap(values, i, j);
//            }
//            else {
//                System.out.println(Arrays.toString(values));
//                System.out.println("OUTPUT "+ i + " " + j);
//                return j;
//            }
//        }

//      programmiz implementation
//      Lomuto Partition
//      I think the base of this algorithm is to bring the first larger than pivot to the right side
//      And to make pivot in the right position
        int i = (low - 1);
        int pivot = values[high];

        for(int j = low; j < high; j++){
            if(values[j] <= pivot){
                i++;
                swap(values, i, j);
            }
        }
        swap(values, i + 1, high);
        return ( i + 1 );
    }

    public static void quickSort(int[] values, int low, int high){
        // Google Engineer Implementation
//        if(low < high){
//            int pivot = partition(values, low, high);
//
//            // left side
//            quickSort(values, low, pivot);
//
//            // right side
//            quickSort(values, pivot + 1, high);
//        }

//        programmiz implementation
//        Lomuto Partition
        if(low < high){
            int pivot = partition(values, low, high);

            quickSort(values, low, pivot - 1);
            quickSort(values, pivot + 1, high);
        }
    }

    // Swap two elements
    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static void main(String[] args){
        int[] array = {3, 2, 1, 5, 6 ,4};
        QuickSort sorter = new QuickSort();
        sorter.sort(array);
        // Prints:
        System.out.println(java.util.Arrays.toString(array));
    }
}
