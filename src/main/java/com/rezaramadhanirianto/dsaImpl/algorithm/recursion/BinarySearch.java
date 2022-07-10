package com.rezaramadhanirianto.dsaImpl.algorithm.recursion;

public class BinarySearch {

    int search(int[] array, int x, int low, int high){
        if(low > high) return -1;

        int mid = (low + high) / 2;

        if(array[mid] == x) return mid;
        else if(array[mid] > x) return search(array, x, low, mid - 1);
        else return search(array, x, mid + 1, high);
    }

    public static void main(String[] args){
        BinarySearch ob = new BinarySearch();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int x = 8;
        int result = ob.search(array, x, 0, array.length - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
