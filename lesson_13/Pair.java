package lesson_13;

public class Pair {
    Object left;
    Object right;

    public Pair(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + left +
                ", " + right + "]";
    }
}
