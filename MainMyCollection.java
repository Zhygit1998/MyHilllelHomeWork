package lesson_9;

import java.util.Arrays;

public class MainMyCollection {
    public static void main(String[] args) {
        String[] coll = new String[3];
        MyCollection entry1 = new MyCollection();
        entry1.add("1");
        entry1.add("2");
        entry1.add("3");
        entry1.add("4");
        entry1.add("5");
        entry1.print(entry1.first);
        System.out.println("Удаление елемента по значению ");
        entry1.delete("4");
        entry1.print(entry1.first);
        System.out.println("Выбор элемента по индексму " + entry1.get(3));
        System.out.println("Размер - " + entry1.size());
        System.out.println("Удаление елемента по индксу");
        entry1.delete(2);
        entry1.print(entry1.first);
        System.out.println("Поиск элемента в массиве - " + entry1.contains("3"));
        coll[0] = "20";
        coll[1] = "21";
        coll[2] = "22";
        System.out.println("Добавить элементы из массива");
        entry1.addAll(coll);
        entry1.print(entry1.first);
        System.out.println("Очистить коллекцию");
        entry1.clear();
        entry1.print(entry1.first);
        MyCollection entry2 = new MyCollection();
        entry2.add("10");
        entry2.add("11");
        entry2.add(null);
        entry2.add("13");
        entry2.add("14");
        entry2.add("15");
        entry2.print(entry2.first);
        System.out.println("Убрать пустые значения");
        entry2.trim();
        entry2.print(entry2.first);
        MyCollection entry3 = new MyCollection();
        entry3.add("10");
        entry3.add("11");
        entry3.add("13");
        entry3.add("14");
        entry3.add("15");
        System.out.println("Сравнить коллеции");
        System.out.println(entry3.compare(entry2));
        System.out.println("Добавить элементы из одной коллекции в другую");
        entry2.addAll(entry3);
        entry2.print(entry2.first);
    }
}
