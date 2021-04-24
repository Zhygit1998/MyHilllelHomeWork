package lesson_9;

import java.util.Collection;

public interface MyCustomCollection {
    void print(Node node);

    boolean add(String str);

    boolean addAll(String[] strArr);

    boolean addAll(MyCollection strColl);

    boolean delete(int index);

    boolean delete(String element);

    String get(int index);

    boolean contains(String str);

    boolean clear();

    int size();

    boolean trim();

    boolean compare(MyCollection coll);

}
