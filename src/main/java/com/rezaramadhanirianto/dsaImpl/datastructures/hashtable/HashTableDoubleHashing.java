package com.rezaramadhanirianto.dsaImpl.datastructures.hashtable;

import java.math.BigInteger;

public class HashTableDoubleHashing<K extends SecondaryHashCode, V> extends HashTableOpenAddressing<K, V> {

    private int hash;

    public HashTableDoubleHashing(){
        super(10);
    }

    protected HashTableDoubleHashing(int capacity) {
        super(capacity);

    }

    @Override
    protected void setupProbing(K key) {
        // Cache second hash value.
        hash = getBucketIndex(key.hashCode2());

        // Fail safe to avoid infinite loop.
        if (hash == 0) hash = 1;
    }

    @Override
    protected int probe(int x) {
        return x * hash;
    }

    // Adjust the capacity until it is a prime number. The reason for
    // doing this is to help ensure that the GCD(hash, capacity) = 1 when
    // probing so that all the cells can be reached.
    @Override
    protected void adjustCapacity() {
        while (!(new BigInteger(String.valueOf(capacity)).isProbablePrime(20))) {
            capacity++;
        }
    }
}
