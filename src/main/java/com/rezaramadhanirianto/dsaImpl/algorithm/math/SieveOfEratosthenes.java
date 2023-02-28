package com.rezaramadhanirianto.dsaImpl.algorithm.math;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public int countPrimesLessThanN(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for(int i = 2; i * i < n; i++){
            if(primes[i]){
                for(int j = i * i; j < n; j += i){
                    primes[j] = false;
                }
            }
        }
        int res = 0;
        for(int i = 2; i < n; i++) if(primes[i]) res++;
        return res;
    }
}
