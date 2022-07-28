package com.rezaramadhanirianto.dsaImpl.bigo;

// O(N!) -> Factorial
// 1 -> 1 -> 1
// 2 -> 1! x 2 -> 2
// 3 -> 2! x 3 -> 6
// 4 -> 3! x 4 -> 24
public class Factorial {

    public static void main(String[] args){
        mostSimpleFactorial(3);
    }

    static void factorial(int n){
        if(n == 0){
            //0(1)
            System.out.println("********");
            return;
        }


        // O(N-1) -> 3, 2, 1
        for(int i = 0; i < n; i++){
            factorial(n-1);
        }
    }

    // n * (n-1)(n-2)(n-3) = n!
    // n * (n-1)! = n!
    static void mostSimpleFactorial(int n) {
        if(n == 0) System.out.println("a");
        for(int i=0; i<n; i++) {
            mostSimpleFactorial(n-1);
        }
    }
}
