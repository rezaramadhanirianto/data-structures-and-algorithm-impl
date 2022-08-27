package com.rezaramadhanirianto.dsaImpl.datastructures.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class TrieTest {

    @Test
    public void test_search(){
        Trie trie = new Trie();

        String[] words = new String[]{"the", "world", "word"};
        for(String word: words) trie.insert(word);

        assertTrue(trie.search("the"));
        assertTrue(trie.search("word"));
        assertFalse(trie.search("wo"));

        assertTrue(trie.contains("wo"));
        assertFalse(trie.contains("wowo"));
    }

    @Test
    public void test_delete(){
        Trie trie = new Trie();

        String[] words = new String[]{"the", "world", "word"};
        for(String word: words) trie.insert(word);

        assertTrue(trie.remove("the"));
        assertFalse(trie.search("the"));

        assertTrue(trie.search("world"));
        assertTrue(trie.remove("world"));
        assertFalse(trie.search("world"));
    }
}