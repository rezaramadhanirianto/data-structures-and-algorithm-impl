package com.rezaramadhanirianto.dsaImpl.datastructures.queue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class QueueTest {

    private List<Queue<Integer>> queues = new ArrayList<>();

    @Before
    public void setup() {
        queues.add(new SimpleCircuralQueue<>(2));
        queues.add(new CircuralQueue<>(2));
    }

    @Test
    public void testEmptyQueue() {
        for (Queue queue : queues) {
            assertThat(queue.isEmpty()).isTrue();
            assertThat(queue.size()).isEqualTo(0);
        }
    }

    @Test(expected = Exception.class)
    public void testPollOnEmpty() {
        for (Queue queue : queues) {
            queue.dequeue();
        }
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        for (Queue queue : queues) {
            queue.peek();
        }
    }

    @Test
    public void testOffer() {
        for (Queue<Integer> queue : queues) {
            queue.enqueue(2);
            assertThat(queue.size()).isEqualTo(1);
        }
    }

    @Test
    public void testPeek() {
        for (Queue<Integer> queue : queues) {
            queue.enqueue(2);
            assertThat((int) queue.peek()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(1);
        }
    }

    @Test
    public void testPoll() {
        for (Queue<Integer> queue : queues) {
            queue.enqueue(2);
            assertThat((int) queue.dequeue()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(0);
        }
    }

    @Test
    public void testExhaustively() {
        for (Queue<Integer> queue : queues) {
            assertThat(queue.isEmpty()).isTrue();
            queue.enqueue(1);
            assertThat(queue.isEmpty()).isFalse();
            queue.enqueue(2);
            assertThat(queue.size()).isEqualTo(2);
            assertThat((int) queue.peek()).isEqualTo(1);
            assertThat(queue.size()).isEqualTo(2);
            assertThat((int) queue.dequeue()).isEqualTo(1);
            assertThat(queue.size()).isEqualTo(1);
            assertThat((int) queue.peek()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(1);
            assertThat((int) queue.dequeue()).isEqualTo(2);
            assertThat(queue.size()).isEqualTo(0);
            assertThat(queue.isEmpty()).isTrue();
        }
    }
}