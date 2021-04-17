import java.util.Arrays;

public class NameCollection {
    private String[] nameCollection;
    private int size;
    private static final int ARR_SIZE_CONST = 8;

    @Override
    public String toString() {
        return "NameCollection{" +
                "nameCollection=" + Arrays.toString(nameCollection) +
                '}';
    }

    public NameCollection() {
        this.nameCollection = new String[ARR_SIZE_CONST];
    }

    public NameCollection(int size) {
        this.nameCollection = new String[size];
    }

    String[] toEnlarge() {
        String[] fakeArr = new String[(nameCollection.length * 2)];
        System.arraycopy(nameCollection, 0, fakeArr, 0, nameCollection.length);
        return fakeArr;
    }

    public boolean add(String element) {
        if (nameCollection.length == size) {
            nameCollection = toEnlarge();
        }
        nameCollection[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, String element) {

        if (nameCollection.length != size) {
            nameCollection = toEnlarge();
        }
        nameCollection[index] = element;
        size++;
        return true;
    }

    public boolean delete(String element) {
        for (int i = 0; i < nameCollection.length; i++) {
            if (nameCollection[i].equals(element)) {
                System.arraycopy(nameCollection, i + 1, nameCollection,
                        i, size - i);
                nameCollection[size] = null;
                return true;
            }
        }
        return false;
    }
    public boolean delete(int index) {
        for (int i = 0; i < nameCollection.length; i++) {
            if (i==index) {
                System.arraycopy(nameCollection, i + 1, nameCollection,
                        i, size - i);
                nameCollection[size] = null;
                return true;
            }
        }
        return false;
    }

    public String get(int index) {
        for (int i = 0; i < nameCollection.length; i++) {
            if (index == i) {
                return nameCollection[i];
            }
        }
        return null;
    }
}