package com.rezaramadhanirianto.dsaImpl.dynamicprogramming.memoization;

public class Fibonacci {
    final int max = 1000;
    int[] fib = new int[max];

    int fibonacci(int num){
        if (num == 0) return 0;
        if (num == 1) return 1;

        if(fib[num] != 0) return fib[num];

        fib[num] = fibonacci(num - 1) + fibonacci(num - 2);
        return fib[num];
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        var output = fibonacci.fibonacci(5);
        System.out.println(output);
    }
}
