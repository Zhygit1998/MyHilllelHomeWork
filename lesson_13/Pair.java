public class Pair {
    Object element_0;
    Object element_1;
    public Pair(Object element_0, Object element_1) {
        this.element_0 = element_0;
        this.element_1 = element_1;
    }

    @Override
    public String toString() {
        return " " + element_0 +
                ", " + element_1 +
                '}';
    }
}
