package lesson6;

import java.util.Comparator;

public class InternetTraficSortedComporator implements Comparator<AbonentData> {
    @Override
    public int compare(AbonentData o1, AbonentData o2) {
        return o2.getTraficOfInternet()-o1.getTraficOfInternet();
    }
}
