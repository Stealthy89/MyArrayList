import com.yachenya.list.MyArrayList;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class MyArrayListTests extends MyArrayList {

    private MyArrayList arrayList = new MyArrayList();
    private ArrayList<Integer> expectedInt = new ArrayList<>();
    private ArrayList<String> expectedStr = new ArrayList<>();

    @Test
    public void testSize() throws Exception {
        expectedInt.add(156);
        arrayList.add(1);
        Assert.assertEquals(expectedInt.size(), arrayList.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertEquals(expectedInt.isEmpty(), arrayList.isEmpty());
        expectedInt.add(2);
        arrayList.add(1);
        arrayList.add("Srt");
        Assert.assertEquals(expectedInt.isEmpty(), arrayList.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        expectedInt.add(2);
        arrayList.add(1);
        arrayList.add("Srt");
        arrayList.add('&');
        Assert.assertEquals(expectedInt.contains(2), arrayList.contains("Srt"));
    }

    @Test
    public void testAdd() throws Exception {
        Assert.assertEquals(expectedStr.add("S"), arrayList.add("S"));
    }

    @Test
    public void testRemove() throws Exception {
        expectedStr.add("S");
        arrayList.add("S");
        Assert.assertEquals(expectedStr.remove("S"), arrayList.remove("S"));
        Assert.assertEquals(expectedStr.remove("A"), arrayList.remove("A"));
    }

    @Test
    public void testClear() throws Exception {
        expectedInt.add(1);
        expectedInt.add(2);

        arrayList.add(1);

        expectedInt.clear();
        arrayList.clear();

        Assert.assertEquals(expectedInt.size(), arrayList.size());
    }

    @Test
    public void testGet() throws Exception {
        expectedInt.add(1);
        expectedInt.add(2);

        arrayList.add(1);
        Assert.assertEquals(expectedInt.get(0), arrayList.get(0));
    }

    @Test
    public void testSet() throws Exception {
        expectedInt.add(1);
        expectedInt.add(2);

        expectedStr.add("A");

        arrayList.add(2);
        arrayList.add(1);
        arrayList.add("A");

        Assert.assertEquals(expectedStr.set(0, "B"), arrayList.set(2, "B"));
        Assert.assertEquals(expectedInt.set(1, 3), arrayList.set(0, 3));
    }


    @Test
    public void testAddVoid() throws Exception {
        expectedInt.add(1);
        expectedInt.add(12);

        arrayList.add(1);
        arrayList.add(12);

        arrayList.add(0, 1);
        expectedInt.add(0,1);

        Assert.assertEquals(expectedInt.get(0), arrayList.get(0));
        Assert.assertEquals(expectedInt.get(1), arrayList.get(1));
        Assert.assertEquals(expectedInt.get(2), arrayList.get(2));
    }

    @Test
    public void testRemoveByIndex() throws Exception {
        expectedInt.add(1);
        expectedInt.add(12);

        arrayList.add(1);
        arrayList.add(12);
        Assert.assertEquals(arrayList.remove(1), expectedInt.remove(1));
       // Assert.assertEquals(arrayList.remove(2), expectedInt.remove(2));
    }
    @Test
    public void testIndexOf() throws Exception {
        expectedInt.add(1);
        expectedInt.add(12);
        expectedInt.add(1);

        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(1);
        Assert.assertEquals(arrayList.indexOf(1), expectedInt.indexOf(1));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        expectedInt.add(1);
        expectedInt.add(12);
        expectedInt.add(1);

        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(1);
        Assert.assertEquals(arrayList.lastIndexOf(1), expectedInt.lastIndexOf(1));
    }
}
