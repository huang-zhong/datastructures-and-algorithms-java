import com.hzzz.www.array.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayTest {

    @Test
    public void test() {
        Array array = new Array(10);
        //array.print();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", array.toString());
        array.remove(5);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 7, 8, 9, 10]", array.toString());
        array.remove(6);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 7, 9, 10]", array.toString());
        array.set(5, 10);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 10, 9, 10]", array.toString());
        array.set(6, 11);
        Assertions.assertEquals("[1, 2, 3, 4, 5, 10, 11, 10]", array.toString());
    }
}
