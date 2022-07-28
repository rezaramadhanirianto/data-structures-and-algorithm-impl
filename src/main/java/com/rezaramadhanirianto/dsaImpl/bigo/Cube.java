package com.rezaramadhanirianto.dsaImpl.bigo;

// O(N³) -> Cube
public class Cube {
    public static void main(String[] args){

    }

    static void cubeFunc(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
