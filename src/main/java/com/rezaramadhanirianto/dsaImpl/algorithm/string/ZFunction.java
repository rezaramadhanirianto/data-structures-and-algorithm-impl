package com.rezaramadhanirianto.dsaImpl.algorithm.string;

import java.util.Arrays;

public class ZFunction {
    public static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n]; // Array to store Z values
        int l = 0, r = 0; // Represents the interval [l, r] such that s[l, r] is the rightmost substring that matches the prefix
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                // If the current index (i) is within the rightmost string.
                // --
                // (r - i + 1) -> Remaining length of the rightmost substring, ex:
                // i = 4, r = 7
                // r = 7, the remaining length would be
                // 7−4+1=4.
                // This means that starting from index 4, there are 4 characters remaining in the rightmost substring.
                // --
                // (i - l) -> current character in pattern
                // Ex: i=4 and l=2, then i−l=2,
                // indicating that i is the 2nd character within the current substring.
                // [2] would retrieve the Z-value computed for the 2nd character in the left interval.
                z[i] = Math.min(r - i + 1, z[i - l]); // Math.min to ensure doesn't exceed right most value
            }

            // Extend the current substring and increment the Z value while the characters match
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            // Update the rightmost interval if the current substring extends beyond it
            if (i + z[i] > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public static void main(String[] args) {
        String text = "aabcaabxaaaz";
        String pattern = "aab";
        // Note: pattern + text
        int[] zValues = zFunction(pattern + "$" + text); // Using $ as a separator
        System.out.println(Arrays.toString(zValues));
        for (int i = 0; i < zValues.length; i++) {
            if (zValues[i] == pattern.length()) {
                System.out.println("Pattern found at index " + (i - pattern.length()));
            }
        }
    }
}
