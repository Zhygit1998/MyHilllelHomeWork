package lesson_8;

import java.util.Arrays;
import java.util.Iterator;

public class CarCollection implements CarCollectionInterface, Iterable<Object> {
    private String[] carCollection;
    private int size;
    private static final int ARR_SIZE_CONST = 8;

    private class Itterator implements Iterator<Object> {

        int count = 0;

        @Override
        public boolean hasNext() {
            return count < carCollection.length && carCollection[count] != null;
        }

        @Override
        public Object next() {
            return carCollection[count++];
        }
    }

    @Override
    public String toString() {
        return "CarCollection{" +
                "carCollection=" + Arrays.toString(carCollection) +
                '}';
    }

    public CarCollection() {

        this.carCollection = new String[ARR_SIZE_CONST];
    }

    public CarCollection(int size) {

        this.carCollection = new String[size];
    }


    String[] toEnlarge() {
        String[] fakeArr = new String[(carCollection.length * 2)];
        System.arraycopy(carCollection, 0, fakeArr, 0, carCollection.length);
        return fakeArr;
    }

    @Override
    public boolean add(String element) {
        if (carCollection.length == size) {
            carCollection = toEnlarge();
        }
        carCollection[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, String element) {

        if (carCollection.length != size) {
            carCollection = toEnlarge();
        }
        carCollection[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean delete(String element) {
        for (int i = 0; i < carCollection.length; i++) {
            if (carCollection[i].equals(element)) {
                System.arraycopy(carCollection, i + 1, carCollection,
                        i, size - i);
                carCollection[size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        for (int i = 0; i < carCollection.length; i++) {
            if (index == i) {
                return carCollection[i];
            }
        }
        return null;
    }

    @Override
    public boolean contain(String element) {
        for (int i = 0; i < carCollection.length; i++) {
            if (element.equals(carCollection[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(String[] arrayCar) {
        return Arrays.equals(carCollection, arrayCar);
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < carCollection.length; i++) {
            carCollection[i] = null;
            size = 0;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Itterator();
    }

}
