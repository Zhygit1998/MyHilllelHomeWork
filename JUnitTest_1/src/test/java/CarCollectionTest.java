import org.junit.Assert;
import org.junit.Test;

public class CarCollectionTest {
    @Test
    public void testAdd(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        String result = "VAZ";
        Assert.assertEquals(carCollection.get(0), result);
    }

    @Test
    public  void testAddIndex(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add(3, "Volga");
        String result = "Volga";
        Assert.assertEquals(carCollection.get(3), result);
    }
    @Test
    public  void testDelete(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add("MAZ");
        carCollection.add("LUAZ");
        carCollection.delete("LUAZ");
        Assert.assertEquals(carCollection.get(2), null);
    }
    @Test
    public void testGet(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add("Mazda");
        carCollection.add("Lamborgini");
        String car = carCollection.get(2);
        String expected = "Lamborgini";
        Assert.assertEquals(expected, car);
    }
    @Test
    public  void testContain(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add("MAZ");
        carCollection.add("LUAZ");
        boolean result = carCollection.contain("MAZ");
        Assert.assertEquals(true, result);

    }
    @Test
    public  void testEquals(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add("MAZ");
        carCollection.add("LUAZ");
        String [] arr = new String[8];
        arr[0] = "VAZ";
        arr[1] = "MAZ";
        arr[2] = "LUAZ";
        arr[3] = null;
        arr[4] = null;
        arr[5] = null;
        arr[6] = null;
        arr[7] = null;
        boolean result = carCollection.equals(arr);
        Assert.assertEquals(true, result);
    }
    @Test
    public  void testClear(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add("MAZ");
        carCollection.add("LUAZ");
        boolean result = carCollection.clear();
        Assert.assertEquals(true, result);

    }
    @Test
    public  void testSize(){
        CarCollection carCollection = new CarCollection();
        carCollection.add("VAZ");
        carCollection.add("MAZ");
        carCollection.add("LUAZ");
        int result = carCollection.size();
        Assert.assertEquals(3, result);
    }
}
