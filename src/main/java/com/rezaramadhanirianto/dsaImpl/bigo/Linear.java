package com.rezaramadhanirianto.dsaImpl.bigo;

// O(N) -> Linear
// because it will run how many arr.length
// 0(N) + 0̶(̶1̶)̶ ̶ we don't count if the big O is constant
// 0(N)
public class Linear {
    public static void main(String[] args){
        linearFunc(new int[]{1,2,3});
    }

    static void linearFunc(int[] arr){
        for(int i = 0; i < arr.length; i++){ // 0(N)
            System.out.println(i); // 0(1)
        }
    }
}
