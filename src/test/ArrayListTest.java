import com.hzzz.www.list.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
        list.add(10);
        list.add(11);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]", list.toString());
                               //1,2,3,4,5,6,7,8,9,10,11
        list.remove(5); //1,2,3,4,5,7,8,9,10,11
        list.remove(6); //1,2,3,4,5,7,9,10,11
        list.remove(7); //1,2,3,4,5,7,9,11
        Assertions.assertEquals("[1, 2, 3, 4, 5, 7, 9, 11]", list.toString());
        list.set(0, 0);
        list.set(1, 1);
        list.set(2, 2);
        Assertions.assertEquals("[0, 1, 2, 4, 5, 7, 9, 11]", list.toString());
        list.clear();
        Assertions.assertEquals("[]", list.toString());
    }

    @Test
    public void testException() {
        System.out.println(5/2);
    }
}
