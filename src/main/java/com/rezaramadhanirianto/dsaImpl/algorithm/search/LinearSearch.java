package com.rezaramadhanirianto.dsaImpl.algorithm.search;

public class LinearSearch {

    int search(int[] array, int x){
        for(int i = 0; i < array.length; i++){
            if(array[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        LinearSearch ls = new LinearSearch();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int x = 4;
        int result = ls.search(array, x);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
