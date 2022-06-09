package com.rezaramadhanirianto.dsaImpl.datastructures.list;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MySingleLinkedListTest extends TestCase {
    MySingleLinkedList<Integer> list;

    @Before
    public void init() {
        list = new MySingleLinkedList<Integer>();
    }

    @Test
    public void test_add() {
        assertTrue(list.isEmpty());

        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);

        assertEquals(4, list.size());
        assertSame(10, list.getByIndex(0));
        list.addFirst(0);
        assertSame(0, list.getByIndex(0));
        assertEquals(5, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void test_remove() {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        assertSame(0, list.removeByIndex(0));
        assertSame(1, list.removeFirst());
        assertSame(3, list.removeLast());
        assertSame(1, list.size());
        assertSame(list.getByIndex(0), 2);
        assertSame(2, list.removeByValue(2));
        assertSame(0, list.size());
        assertTrue(list.isEmpty());

    }
}