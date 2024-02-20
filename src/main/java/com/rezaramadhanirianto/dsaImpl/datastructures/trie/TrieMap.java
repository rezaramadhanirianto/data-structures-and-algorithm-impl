package com.rezaramadhanirianto.dsaImpl.datastructures.trie;

import java.util.HashMap;

public class TrieMap implements Trie {
    private final TrieNode root;

    public TrieMap() {
        root = new TrieNode();
    }

    @Override
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (!current.children.containsKey(index)) {
                current.children.put(index, new TrieNode());
            }
            current = current.children.get(index);
        }
        current.count++;
    }

    @Override
    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.count > 0;
    }

    @Override
    public boolean remove(String word) {
        TrieNode node = traverse(word);
        if (node != null && node.count > 0) {
            node.count--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String key) {
        TrieNode node = traverse(key);
        return node != null;
    }

    @Override
    public int count(String key) {
        TrieNode node = traverse(key);
        return node != null ? node.count : 0;
    }

    private TrieNode traverse(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            current = current.children.get(index);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        TrieMap trieArray = new TrieMap();
        trieArray.insert("apple");
        trieArray.insert("orange");
        trieArray.insert("banana");

        System.out.println(trieArray.search("apple"));   // true
        System.out.println(trieArray.search("orange"));  // true
        System.out.println(trieArray.search("banana"));  // true
        System.out.println(trieArray.search("grape"));   // false

        System.out.println("Removing 'apple': " + trieArray.remove("apple"));
        System.out.println(trieArray.search("apple"));   // false
    }

    class TrieNode {
        HashMap<Integer, TrieNode> children = new HashMap<>();
        int count = 0;
    }
}
