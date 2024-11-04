import com.hzzz.www.stack.JDKLinkedListStack;
import org.junit.jupiter.api.Test;

public class JDKLinkedListStackTest {
    @Test
    public void test(){
        JDKLinkedListStack<Integer> stack = new JDKLinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
