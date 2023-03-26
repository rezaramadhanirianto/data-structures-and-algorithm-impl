package com.rezaramadhanirianto.dsaImpl.datastructures.tree;

public class FenwickTree {
    // The size of the array holding the Fenwick tree values
    final int N;

    // This array contains the Fenwick tree ranges
    private long[] tree;

    public FenwickTree(int sz) {
        tree = new long[(N = sz + 1)];
    }

    public FenwickTree(long[] values) {
        if (values == null) throw new IllegalArgumentException("Values array cannot be null!");

        N = values.length;
        values[0] = 0L;

        tree = values.clone();

        for (int i = 1; i < N; i++) {
            int parent = i + lsb(i);
            if (parent < N) tree[parent] += tree[i];
        }
    }

    // Returns the value of the least significant bit (LSB)
    // lsb(108) = lsb(0b1101100) =     0b100 = 4
    // lsb(104) = lsb(0b1101000) =    0b1000 = 8
    // lsb(96)  = lsb(0b1100000) =  0b100000 = 32
    // lsb(64)  = lsb(0b1000000) = 0b1000000 = 64
    private static int lsb(int i) {
        // Isolates the lowest one bit value
        return i & -i;
        // An alternative method is to use the Java's built in method
        // return Integer.lowestOneBit(i);
    }

    // Computes the prefix sum from [1, i], O(log(n))
    private long prefixSum(int i) {
        long sum = 0L;
        while (i != 0) {
            sum += tree[i];
            i &= ~lsb(i); // Equivalently, i -= lsb(i);
        }
        return sum;
    }

    // Returns the sum of the interval [left, right], O(log(n))
    public long sum(int left, int right) {
        if (right < left) throw new IllegalArgumentException("Make sure right >= left");
        return prefixSum(right) - prefixSum(left - 1);
    }

    // Get the value at index i
    public long get(int i) {
        return sum(i, i);
    }

    public void add(int i, long v){
        while(i < N){
            tree[i] += v;
            i += lsb(i);
        }
    }

    public void set(int i, long v) {
        add(i, v - sum(i, i));
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(tree);
    }
}
