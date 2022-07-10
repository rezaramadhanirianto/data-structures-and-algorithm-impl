package com.rezaramadhanirianto.dsaImpl.algorithm.classic;

public class Fibonacci {

    int fibonacci(int x){
        int a = 0, b = 1;
        int output = 0;
        for(int i = 1; i < x; i++){
            output = a + b;

            a = b;
            b = output;
        }
        return output;
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        var output = fibonacci.fibonacci(8);
        System.out.println(output);
    }
}
