package com.rezaramadhanirianto.dsaImpl.dynamicprogramming.bottomup;

public class Fibonacci {
    int fibonacci(int n){
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        var output = fibonacci.fibonacci(5);
        System.out.println(output);
    }
}
