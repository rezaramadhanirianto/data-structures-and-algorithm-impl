package com.rezaramadhanirianto.dsaImpl.algorithm;

public class KadaneAlgorithm {
    public static void main(String[] args)
    {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    static int maxSubArraySum(int[] nums)
    {
        int max = Integer.MIN_VALUE, maxHere = 0;
        for (int num : nums) {
            maxHere += num;
            if (max < maxHere) max = maxHere;
            if (maxHere < 0) maxHere = 0;
        }
        return max;
    }
}
