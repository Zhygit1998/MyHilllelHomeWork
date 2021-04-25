package lesson_10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MainDuplicateRemover {
    public static void main(String[] args) {
        ArrayList<Object> coll = new ArrayList<>();
        coll.add("coll1");
        coll.add("coll5");
        coll.add(1);
        coll.add(1);
        coll.add("coll1");
        coll.add(3);
        coll.add(5);
        coll.add(5);
        coll.add(7);
        System.out.println(removeDuplicate(coll));
    }
    public static Collection <Object> removeDuplicate(ArrayList<Object> collRemove){
        return collRemove.stream().distinct().collect(Collectors.toList());
    }
}
