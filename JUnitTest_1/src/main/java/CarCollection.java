
    import java.util.Arrays;

    public class CarCollection {
        private String[] carCollection;
        private int size;
        private static final int ARR_SIZE_CONST = 8;

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

        public boolean add(String element) {
            if (carCollection.length == size) {
                carCollection = toEnlarge();
            }
            carCollection[size] = element;
            size++;
            return true;
        }

        public boolean add(int index, String element) {

            if (carCollection.length != size) {
                carCollection = toEnlarge();
            }
            carCollection[index] = element;
            size++;
            return true;
        }

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

        public String get(int index) {
            for (int i = 0; i < carCollection.length; i++) {
                if (index == i) {
                    return carCollection[i];
                }
            }
            return null;
        }

        public boolean contain(String element) {
            for (int i = 0; i < carCollection.length; i++) {
                if (element.equals(carCollection[i])) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(String[] arrayCar) {
            return Arrays.equals(carCollection, arrayCar);
        }


        public boolean clear() {
            for (int i = 0; i < carCollection.length; i++) {
                carCollection[i] = null;
                size = 0;
            }
            return true;
        }

        public int size() {
            return size;
        }
    }
