package com.rezaramadhanirianto.dsaImpl.algorithm.search;

public class BinarySearch {

    int search(int[] array, int x){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] == x){
                return mid;
            }else if(array[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        BinarySearch ob = new BinarySearch();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int x = 4;
        int result = ob.search(array, x);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
