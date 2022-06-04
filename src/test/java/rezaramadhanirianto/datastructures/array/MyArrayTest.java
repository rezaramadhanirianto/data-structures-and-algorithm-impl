package rezaramadhanirianto.datastructures.array;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyArrayTest extends TestCase {
    MyArray<Object> data;

    @Before
    public void init(){
        data = new MyArray<Object>();
    }

    @Test
    public void test_add(){
        for(int i = 0; i < 20; i++){
            data.add(i);
        }
        assertEquals(20, data.size());
    }

    @Test
    public void test_remove(){
        data.add(3);
        data.add(4);
        data.add(4);
        data.remove(4);
        assertEquals(1, data.size());
    }
}