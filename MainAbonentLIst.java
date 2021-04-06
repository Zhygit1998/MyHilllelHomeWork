package lesson6;


import java.util.*;

public class MainAbonentLIst {
    public static void main(String[] args) {
        int limitCalls = 300;
        int count = 0;
        List<AbonentData> abonentArray = new ArrayList<>();
        AbonentData abonent_0 = new AbonentData(25, "Жигит", "Павел", "Алексеевич",
                "Терешковой 22", 1234567, 12548754, 100, 123, 10, 0, 45);
        AbonentData abonent_1 = new AbonentData(47, "Костев", "Виктор", "Олегович",
                "Невского 9", 1258457, 15454548, 120, 212, 13, 15, 45);
        AbonentData abonent_2 = new AbonentData(45, "Викторов", "Виктор", "Валерьевич",
                "Братиславская 23", 121477, 15455578, 120, 140, 45, 78, 78);
        AbonentData abonent_3 = new AbonentData(78, "Кравец", "Михаил", "Григорьевич",
                "Невского 15", 126987, 54542154, 45, 23, 45, 78, 125);
        AbonentData abonent_4 = new AbonentData(485, "Ткаченко", "Ксения", "Олегович",
                "Суворова 121", 122132, 45454544, 455, 454, 45, 124, 452);
        AbonentData abonent_5 = new AbonentData(452, "Ивлеева", "Анастасия", "Сергеевна",
                "Михайловская 256", 128757, 21155444, 754, 213, 457, 0, 1087);
        AbonentData abonent_6 = new AbonentData(78, "Куртев", "Константин", "Михайлович",
                "Маяковского 73", 1252427, 454353453, 5345, 23, 432, 123, 2432);
        AbonentData abonent_7 = new AbonentData(96, "Калев", "Константин", "Васильевич",
                "Маяковского 233", 345435435, 53454353, 345, 123, 241, 0, 44);
        AbonentData abonent_8 = new AbonentData(13, "Бондарь", "Константин", "Михайлович",
                "Маяковского 713", 3534534, 4543532, 345, 123, 1313, 2321, 223);
        AbonentData abonent_9 = new AbonentData(17, "Вироник", "Константин", "Михайлович",
                "Маяковского 7123", 3534534, 345345345, 234, 432, 215, 1312, 445);
        AbonentData abonent_10 = new AbonentData(21, "Фучеджи", "Константин", "Михайлович",
                "Маяковского 75354", 1234427, 3543534, 131, 432, 4113125, 123, 95);
        abonentArray.add(abonent_0);
        abonentArray.add(abonent_1);
        abonentArray.add(abonent_2);
        abonentArray.add(abonent_3);
        abonentArray.add(abonent_4);
        abonentArray.add(abonent_5);
        abonentArray.add(abonent_6);
        abonentArray.add(abonent_7);
        abonentArray.add(abonent_8);
        abonentArray.add(abonent_9);
        abonentArray.add(abonent_10);
        System.out.println("Сведения об абонентах, у которых время внутригородских разговоров превышает заданное - " + limitCalls);
        for (AbonentData cityCalls : abonentArray) {
            cityCalls.sortedLimitCityCalls(limitCalls);
        }
        System.out.println("Сведения об абонентах, которые пользовались междугородной связью;");
        for (AbonentData interCityCalls : abonentArray) {
            interCityCalls.sortedUseInterCityCalls();
        }
        System.out.println("Сведения об абонентах в алфавитном порядке.");
        Comparator nameSortedComporator = new NameSortedComparator();
        Collections.sort(abonentArray, nameSortedComporator);
        for (AbonentData nameSort : abonentArray) {
            nameSort.sortedInformation();
        }
        System.out.println("Сведения об первых 10 абонентов у который самый большой трафик интернета");
        Comparator traficSortedComporator = new InternetTraficSortedComporator();
        Collections.sort(abonentArray, traficSortedComporator);
        for (AbonentData traficSort : abonentArray) {
            if (count < 10) {
                traficSort.sortedInformation();
           }
          count++;
        }
    }
}
