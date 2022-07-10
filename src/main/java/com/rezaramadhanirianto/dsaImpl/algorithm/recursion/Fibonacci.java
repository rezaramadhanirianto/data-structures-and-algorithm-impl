package com.rezaramadhanirianto.dsaImpl.algorithm.recursion;

public class Fibonacci {

    int fibonacci(int x){
        if(x < 2)
            return x;
        return fibonacci(x - 1) + fibonacci(x -2);
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        var output = fibonacci.fibonacci(8);
        System.out.println(output);
    }
}
