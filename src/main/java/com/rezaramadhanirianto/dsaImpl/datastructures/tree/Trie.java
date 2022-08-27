package com.rezaramadhanirianto.dsaImpl.datastructures.tree;

// Trie
public class Trie {
    static final int ALPHABET_SIZE = 26;

    class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

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

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
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

    public static void main(String[] args){
        String[] words = new String[]{"the", "world", "word"};
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        System.out.println(trie.search("the"));
        System.out.println(trie.search("word"));
        System.out.println(trie.search("words"));
    }
}
