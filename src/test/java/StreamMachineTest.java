import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamMachineTest {
    @Test
    public void testAverageCount() {

        double expected = 5.4D;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(4);
        list.add(9);
        list.add(6);
        double actual = StreamMachine.averageCount(list);

        Assert.assertEquals(expected, actual, 0.0D);
    }

    @Test
    public void testListLower_4() {
        ArrayList<String> nameList = new ArrayList<>();
        List<String> actual;
        List<String> expected = new ArrayList<>();

        expected.add("egor");
        expected.add("vlad");
        expected.add("dima");

        nameList.add("egor");
        nameList.add("vlad");
        nameList.add("MASHA");
        nameList.add("Pasha");
        nameList.add("Anna");
        nameList.add("dima");
        actual = StreamMachine.listLower_4(nameList);
        Assert.assertEquals(actual, expected);
    }

}
