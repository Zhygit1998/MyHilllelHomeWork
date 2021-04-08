package lesson7;

public class MainCarCollection {
    public static void main(String[] args) {
        CarCollection carCollection =new CarCollection(10);
        System.out.println("Добавление єлементов массива по значению");
        carCollection.addCarCollectionV("UAZ");
        carCollection.addCarCollectionV("Toyota");
        carCollection.addCarCollectionV("GAZ");
        carCollection.addCarCollectionV("Toyota");
        System.out.println(carCollection.toString());
        System.out.println("Добавление єлементов массива по и ндексу и значению");
        carCollection.addCarCollectionIV(0,"BMW");
        carCollection.addCarCollectionIV(2,"VAZ");
        carCollection.addCarCollectionIV(4,"Maserati");
        carCollection.addCarCollectionIV(3,"Mercedes");
        System.out.println(carCollection.toString());
        System.out.println("Удаление элементов массива по индексу или значению");
        carCollection.removeCarCollectionI(3);
        carCollection.removeCarCollectionV("Maserati");
        System.out.println(carCollection.toString());
        System.out.println("Выбор элемента массива по индксу");
        System.out.println("Second element of array - "+carCollection.getCarCollection(2));
    }

}
