package uvg.edu.gt;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyStackTest {

    @Test
    public void testPushAndPop() throws Exception {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }

    @Test
    public void testTop() throws Exception {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.top().intValue());
        assertEquals(2, stack.top().intValue()); 
    }

    @Test
    public void testEmpty() {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.empty());

        stack.push(1);
        assertFalse(stack.empty());
    }

    @Test
    public void testSize() {
        MyStack<Integer> stack = new MyStack<>();
        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2);
        assertEquals(2, stack.size());
    }
}
