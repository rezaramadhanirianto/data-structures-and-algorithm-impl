package rezaramadhanirianto.datastructures.stack;

import com.rezaramadhanirianto.dsaImpl.datastructures.stack.ArrayStack;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayStackTest extends TestCase {

    private ArrayStack<Integer> arrayStack;

    @Before
    public void init() {
        arrayStack = new ArrayStack<Integer>();
    }

    @Test
    public void test_pop_push(){
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);

        assertEquals(arrayStack.size(), 4);

        assertSame(arrayStack.pop(), 4);
        assertSame(arrayStack.pop(), 3);
        assertSame(arrayStack.pop(), 2);
        assertSame(arrayStack.pop(), 1);

        assertEquals(arrayStack.size(), 0);
    }

    @Test
    public void test_increase_capacity(){
        for (int i = 0; i < 25; i++){
            arrayStack.push(i);
        }
        assertEquals(arrayStack.size(), 25);
    }
}