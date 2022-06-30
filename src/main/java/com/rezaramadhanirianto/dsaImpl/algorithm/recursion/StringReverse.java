package com.rezaramadhanirianto.dsaImpl.algorithm.recursion;

public class StringReverse {

    public String stringReverse(String result){
        if(result.isEmpty()) return result;
        return stringReverse(result.substring(1)) + result.charAt(0);
    }

    public static void main(String[] args){
        StringReverse stringReverse = new StringReverse();
        var str = stringReverse.stringReverse("test");
        System.out.println(str);
    }
}
