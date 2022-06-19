package com.rezaramadhanirianto.dsaImpl.datastructures.hashtable;

public class HashTableLinearProbing<K, V> extends HashTableOpenAddressing<K, V> {
    private static final int LINEAR_CONSTANT = 17;

    public HashTableLinearProbing(){
        super(10);
    }
    protected HashTableLinearProbing(int capacity) {
        super(capacity);
    }

    @Override
    protected void setupProbing(Object key) {

    }

    @Override
    protected int probe(int x) {
        return LINEAR_CONSTANT * x;
    }

    @Override
    protected void adjustCapacity() {
        while (gcd(LINEAR_CONSTANT, capacity) != 1) {
            capacity++;
        }
    }
}
