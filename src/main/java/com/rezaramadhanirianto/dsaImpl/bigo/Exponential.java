package com.rezaramadhanirianto.dsaImpl.bigo;

import java.security.KeyPair;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

// O(2ⁿ) -> Exponential
public class Exponential {
    public static void main(String args[]){
        exponential(3);
    }

    // 2 -> call function 3
    // 5 -> call function 15 -> 2⁴ -> 2ⁿ
    static int exponential(int n){
        int[] arr = new int[]{0,1,2,3,4,5,6};
        int i = 0;
        int output = 0;
        while(i < arr.length){
            if(i == 1) i+=2;
            else i++;
            System.out.println(i);
            output++;
        }
        System.out.println("Output: " + output);
//        for (int j = 0; j < arr.length; j++) {
//            System.out.println(j);
//        }
        return 0;

//        String wordAgain = String.valueOf(wordAt1);
//        String words = String.valueOf(wordArray);
//        return exponential(n -1) + exponential(n -2);
    }
}
