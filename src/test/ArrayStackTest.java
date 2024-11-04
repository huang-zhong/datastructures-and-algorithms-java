import com.hzzz.www.stack.ArrayStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {
    @Test
    public void test1() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void test2() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("java");
        stack.push("python");
        Assertions.assertEquals(4, stack.size());
        Assertions.assertEquals("python", stack.peek());
        stack.pop();
        Assertions.assertEquals("java", stack.peek());
        stack.pop();
        Assertions.assertEquals("world", stack.peek());
        stack.pop();
        Assertions.assertEquals("hello", stack.peek());
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.size());
    }
}
