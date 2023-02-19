package com.rezaramadhanirianto.dsaImpl.datastructures.tree;

import java.util.Objects;

// Trie
public class Trie {
    static final int ALPHABET_SIZE = 26;
    TrieNode root = new TrieNode();

    void insert(String key){
        int n = key.length(), index = 0;

        TrieNode trav = root;
        for (int i = 0; i < n; i++)
        {
            index = key.charAt(i) - 'a';
            if(trav.children[index] == null) trav.children[index] = new TrieNode();

            trav.count++;
            trav = trav.children[index];
        }

        trav.count++;
        trav.isEndOfWord = true;
    }

    public boolean remove(String key){
        if (!contains(key)) return false;

        TrieNode trav = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            trav = trav.children[c - 'a'];
            trav.count--;
        }
        fixTrie(root, key);
        return true;
    }

    public boolean contains(String key){
        return count(key) != 0;
    }

    public int count(String key){
        if (key == null) throw new IllegalArgumentException("Null not permitted");
        TrieNode trav = root;

        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            trav = trav.children[c - 'a'];
            if(trav == null) return 0;
        }

        if(trav != null) return trav.count;
        return 0;
    }

    // remove elements from cache
    TrieNode fixTrie(TrieNode trav, String key){
        if(key.equals("")){
            return null;
        }
        fixTrie(trav.children[key.charAt(0) - 'a'], key.substring(1));
        if(trav.children[key.charAt(0) - 'a'].count == 0){
            trav.children[key.charAt(0) - 'a'] = null;
        }
        return null;
    }

    boolean search(String key){
        int level;
        int length = key.length();
        int index;

        TrieNode trav = root;

        for(level = 0; level < length; level++){
            index = key.charAt(level) - 'a';

            if (trav.children[index] == null)
                return false;

            trav = trav.children[index];
        }

        return (trav.isEndOfWord);
    }

    // node class
    class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        int count = 0;
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    }
}
