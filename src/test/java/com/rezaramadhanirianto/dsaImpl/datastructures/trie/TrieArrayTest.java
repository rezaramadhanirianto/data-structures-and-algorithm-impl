package com.rezaramadhanirianto.dsaImpl.datastructures.trie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieArrayTest {

    @Test
    public void testInsertAndSearch() {
        Trie trie = new TrieArray();
        trie.insert("apple");
        trie.insert("orange");
        trie.insert("banana");

        assertTrue(trie.search("apple"));
        assertTrue(trie.search("orange"));
        assertTrue(trie.search("banana"));
        assertFalse(trie.search("grape"));
    }

    @Test
    public void testRemove() {
        Trie trie = new TrieArray();
        trie.insert("apple");
        trie.insert("orange");
        trie.insert("banana");

        assertTrue(trie.remove("apple"));
        assertFalse(trie.search("apple"));
        assertTrue(trie.search("orange"));
        assertTrue(trie.search("banana"));
    }

    @Test
    public void testContainsAndCount() {
        Trie trie = new TrieArray();
        trie.insert("apple");
        trie.insert("banana");

        assertTrue(trie.contains("apple"));
        assertFalse(trie.contains("orange"));
        assertEquals(1, trie.count("apple"));
        assertEquals(0, trie.count("orange"));
        assertEquals(1, trie.count("banana"));
    }
}
