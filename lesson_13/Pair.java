public class Pair {
    Object element_0;
    Object element_1;
    public Pair(Object element_1, Object element_2) {
        this.element_0 = element_1;
        this.element_1 = element_2;
    }

    @Override
    public String toString() {
        return " " + element_0 +
                ", " + element_1 +
                '}';
    }
}
