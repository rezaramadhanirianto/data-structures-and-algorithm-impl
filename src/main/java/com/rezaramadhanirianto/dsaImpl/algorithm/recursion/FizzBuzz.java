package com.rezaramadhanirianto.dsaImpl.algorithm.recursion;

import java.util.Arrays;

public class FizzBuzz {
    public String[] fizzBuzz(int num, String[] result){
        if(num == 100){ return result;}
        result[num] = checkFizzBuzz(num);
        return fizzBuzz(num + 1, result);
    }

    private String checkFizzBuzz(int num){
        if(num == 0){
            return String.valueOf(num);
        } else if(num % 15 == 0)
            return "FIZZBUZZ";
        else if(num % 5 == 0)
            return "Buzz";
        else if(num % 3 == 0)
            return "Fizz";
        else
            return String.valueOf(num);
    }

    public static void main(String[] args){
        FizzBuzz fizzBuzz = new FizzBuzz();
        var arr = fizzBuzz.fizzBuzz(0, new String[100]);
        System.out.println(Arrays.toString(arr));
    }
}
