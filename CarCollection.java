package lesson7;

import java.util.ArrayList;

public class CarCollection {
    private ArrayList car;
    private int count = 0;
    private int sizeArray;

    public CarCollection(int sizeArray) {
        this.car = new ArrayList(sizeArray);
    }

    public int getSizeArray() {
        return sizeArray;
    }

    public void setSizeArray(int sizeArray) {
        this.sizeArray = sizeArray;
    }

    @Override
    public String toString() {
        return "CarCollection{" +
                "car=" + car +
                '}';
    }
    public void addCarCollectionIV(int index, String value) {
        car.add(index, value);
    }

    public void addCarCollectionV(String value) {
        car.add(value);
    }

    public void removeCarCollectionI(int index) {
        car.remove(index);
    }

    public void removeCarCollectionV(String value) {
        car.remove(value);
    }

    public String getCarCollection(int index) {
        return (String) car.get(index);
    }
}
