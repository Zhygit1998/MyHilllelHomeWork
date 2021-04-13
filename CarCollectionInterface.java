package lesson_8;

public interface CarCollectionInterface {
    boolean add(String element);

    boolean add(int index, String element);

    boolean delete(String element);

    String get(int index);

    boolean contain(String element);

    boolean equals(String[] arrayCar);

    boolean clear();

    int size();
}
