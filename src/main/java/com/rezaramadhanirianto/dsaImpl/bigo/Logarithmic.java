package com.rezaramadhanirianto.dsaImpl.bigo;

// O (log N) -> Logarithmic
// Log 8 -> 3
// 2³ = 8
public class Logarithmic {
    public static void main(String[] args){
        logarithmicRecursion(8);
    }

    static int logarithmicRecursion(int n){
        if(n == 1) return 1;
        n = n/2;
        System.out.println(n);
        return logarithmicRecursion(n);
    }

    static void logarithmic(int n){
        while(n > 1){
            n = n/2;
            System.out.println(n);
        }
    }
}
