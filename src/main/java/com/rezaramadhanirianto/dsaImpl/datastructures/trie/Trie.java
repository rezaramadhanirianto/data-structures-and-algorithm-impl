package com.rezaramadhanirianto.dsaImpl.datastructures.trie;

public interface Trie {
    void insert(String key);

    boolean remove(String key);

    boolean contains(String key);

    int count(String key);

    boolean search(String key);
}