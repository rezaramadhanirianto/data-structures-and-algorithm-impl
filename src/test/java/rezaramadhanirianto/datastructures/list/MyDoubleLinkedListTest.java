package rezaramadhanirianto.datastructures.list;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyDoubleLinkedListTest extends TestCase {
    MyDoubleLinkedList<Integer> list;

    @Before
    public void init(){
        list = new MyDoubleLinkedList<Integer>();
    }

    @Test
    public void test_add(){
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.addFirst(1);

        assertEquals(5, list.size());
    }

    @Test
    public void test_remove(){
        list.add(10);
        list.add(11);
        list.add(12);

        list.removeFirst();
        list.removeLast();
    }

    @Test
    public void test_get(){
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(4);

        assertSame(list.getByIndex(0), 0);
        assertSame(list.getByIndex(1), 2);
        assertSame(list.getByIndex(3), 4);
    }

    @Test
    public void test_index_of_and_contains(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(list.indexOf(4), 3);
        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(9), -1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(0));
    }
}