package com.rezaramadhanirianto.dsaImpl.datastructures.queue;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SimpleCircuralQueueTest extends TestCase {
    SimpleCircuralQueue<Integer> queue;

    @Before
    public void init(){
        queue = new SimpleCircuralQueue(5);
    }

    @Test
    public void test_all(){
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());
        assertSame(1, queue.dequeue());
        assertSame(2, queue.dequeue());
        assertSame(3, queue.dequeue());
        assertSame(4, queue.dequeue());
        assertTrue(queue.isEmpty());
        for (int i = 0; i < 5; i++){
            queue.enqueue(i);
        }
        assertSame(queue.size(), 5);
    }
}