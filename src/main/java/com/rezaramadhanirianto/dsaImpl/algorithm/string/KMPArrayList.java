package com.rezaramadhanirianto.dsaImpl.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class KMPArrayList {
    void getPatternMatchingIndex(String s, String a, List<Integer> res){
        String t = a + " " + s;
        List<Integer> longestPref = new ArrayList<>();
        longestPref.add(0);
        for(int i = 1; i < t.length(); ++i){
            int ind = longestPref.get(i - 1);
            while(ind > 0 && t.charAt(ind) != t.charAt(i)) {
                ind = longestPref.get(ind - 1);
            }
            longestPref.add((t.charAt(ind) == t.charAt(i)) ? ind + 1 : 0);
        }
        for(int i = 0; i < longestPref.size(); ++i){
            if(longestPref.get(i) == a.length()) res.add(i - 2 * a.length());
        }
    }

    public static void main(String[] args) {
        var res = new ArrayList<Integer>();
        new KMPArrayList().getPatternMatchingIndex("abcxababcd","abcd", res);
        System.out.println(res);
    }
}
