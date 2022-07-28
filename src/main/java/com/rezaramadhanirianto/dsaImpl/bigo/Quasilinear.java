package com.rezaramadhanirianto.dsaImpl.bigo;

// O(N log N) -> Quasilinear Time
public class Quasilinear {
    public static void main(String[] args){
        quasilinear(4);
    }

    static void quasilinear(int n){
        int y = n;
        while(n > 1){
            n = n/2;
            for(int i = 0; i < y; i++){
                System.out.println(n);
            }
        }
    }
}
