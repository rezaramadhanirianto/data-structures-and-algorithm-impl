package com.rezaramadhanirianto.dsaImpl.bigo;

// O(2ⁿ) -> Exponential
public class Exponential {
    public static void main(String args[]){
        System.out.println(exponential(3));
    }

    static int exponential(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        return exponential(n -1) + exponential(n -2);
    }
}
