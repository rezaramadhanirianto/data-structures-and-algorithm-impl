package com.rezaramadhanirianto.dsaImpl.algorithm.search.classic;

public class BinarySearch2 {

    int search(int[] array, int x){
        int low = 0;
        // case 1
        // This code is really closely related with code in while(low <= high)
        // if we add high = array.length and while(low <= high)
        // there's a case when we search arr(1,2,3), 4 in arr it will be null pointer
        // because when we call array[4] but size is 3
        // case 2
        // if we add array.length - 1 it will be not null pointer anymore
        int high = array.length - 1;

        // case 1
        // this code is closely related with return value and low = value
        // if we add while(low < high), there's a case when we search arr(1,2,3), we search 1 it will be run high = mid - 1;
        // and go return low, which is when we declare low = 0, it will return 0, when declare low = -1, it will return -1
        // not if(array[mid] == x), because there's never reach code low = 0, and high = 0;
        // that's why when we have low = 0, it will return 0 if we declare low = -1 it will be return -1
        // same with we search 3, it will run low = mid + 1 and return 2
        // case 2
        // if we add while(low <= high), there's a case when we search arr(1,2,3), we search 1 it will run if(array[mid] == x)
        // because there will be case low = 0, high = 0;
        // and there's a case when we search 4 in arr, it will return 3, because low = 2, and high = 2, because still 4 > 3, so still run low = mid + 1;
        while(low <= high){
            int mid = (low + high) / 2;
            System.out.println(low + " + " + high + " = " + mid);
            if(array[mid] == x){
                return mid;
            }else if(array[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        BinarySearch2 ob = new BinarySearch2();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int x = 10;
        int result = ob.search(array, x);
        System.out.println("Element found at index " + result);
    }
}
