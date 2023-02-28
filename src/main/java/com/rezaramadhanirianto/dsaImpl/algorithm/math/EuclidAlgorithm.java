package com.rezaramadhanirianto.dsaImpl.algorithm.math;

public class EuclidAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(4, 10)); // 2
    }

    static int gcd(int a, int b)
    {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
