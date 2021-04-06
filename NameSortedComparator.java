package lesson6;

import java.util.Comparator;

public class NameSortedComparator implements Comparator<AbonentData> {
    @Override
    public int compare(AbonentData o1, AbonentData o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
