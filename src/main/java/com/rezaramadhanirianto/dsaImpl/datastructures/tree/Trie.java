package com.rezaramadhanirianto.dsaImpl.datastructures.tree;

import java.util.Objects;

// Trie
public class Trie {
    static final int ALPHABET_SIZE = 26;

    class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        int count = 0;
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    }

    TrieNode root = new TrieNode();

    void insert(String key){
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null) pCrawl.children[index] = new TrieNode();
            pCrawl.count++;
            pCrawl = pCrawl.children[index];
        }

        pCrawl.count++;
        pCrawl.isEndOfWord = true;
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

    TrieNode fixTrie(TrieNode node, String key){
        if(key.equals("")){
            return null;
        }
        fixTrie(node.children[key.charAt(0) - 'a'], key.substring(1));
        if(node.children[key.charAt(0) - 'a'].count == 0){
            node.children[key.charAt(0) - 'a'] = null;
        }
        return null;
    }

    boolean search(String key){
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for(level = 0; level < length; level++){
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }
}
