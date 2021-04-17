public class
MainNameCollection {
    public static void main(String[] args) {
        NameCollection nameCollection = new NameCollection();
        // Добавлене по значению
        nameCollection.add("Vasiliy");
        nameCollection.add("Maria");
        nameCollection.add("Vika");
        nameCollection.add("Alexey");
        nameCollection.add("Pavel");
        // Добавление по индексу и значению
        nameCollection.add(2, "Alla");
        // Удаление по значению
        nameCollection.delete("Vasiliy");
        // Удаление по индексу
        nameCollection.delete(0);
        System.out.println(nameCollection);
        // Достать по индексу
        System.out.println(nameCollection.get(2));
    }
}
