package lesson_8;

import java.util.Arrays;

public class CarCollectionMain {
    public static void main(String[] args) {
        CarCollection carCollection_0 = new CarCollection();
        CarCollection carCollection_1 = new CarCollection();
        carCollection_0.add("Toyota");
        carCollection_0.add("Mazda");
        carCollection_0.add("Infinity");
        carCollection_0.add("Honda");
        carCollection_0.add("Maserati");
        carCollection_0.add(1, "VAZ");
        System.out.println("Original Array: ");
        System.out.println(carCollection_0);
        carCollection_0.delete("Honda");
        System.out.println("Version remove element: ");
        System.out.println(carCollection_0);
        System.out.println("Get element of index 2 - " + carCollection_0.get(2));
        System.out.println("Contain element Maserati? - " + carCollection_0.contain("Maserati"));
        carCollection_1.add("Lambo");
        carCollection_1.add("Mercedes");
        carCollection_1.add("GAZ");
        carCollection_1.add("Jeep");
        System.out.println("Size Array carCollection - " + carCollection_0.size() + " element");
        System.out.println("Equals carCollection_0 and carCollection_1? - " + carCollection_0.equals(carCollection_1));
        carCollection_0.clear();
        System.out.println("Cleaned Array "+carCollection_0);
        CarCollection carCollection_3 = new CarCollection();
        carCollection_3.add("Toyota");
        carCollection_3.add("Mazda");
        carCollection_3.add("Infinity");
        carCollection_3.add("Honda");
        carCollection_3.add("Maserati");
        for (Object car: carCollection_3) {
            System.out.println(car);
            System.out.println();
        }
    }
}
