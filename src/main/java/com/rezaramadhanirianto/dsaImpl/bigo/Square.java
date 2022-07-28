package com.rezaramadhanirianto.dsaImpl.bigo;

// O(N²) -> Square
public class Square {
    public static void main(String[] args){
        square(5);
    }

    static void square(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.println(i + " " + j);
            }
        }
    }
}
