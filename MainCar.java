package lesson_4;

public class MainCar {
    public static void main(String[] args) {
        float stay_1  =178.6f;
        float stay_2  =153.3f;
        float stay_3  =148.3f;

        float countLitres = 0;
        float money = Float.valueOf(args[0]);
         Car way = new Car(39.9f, 12.6f, 7.6f);
        System.out.println("Перед выездом нужно заправиться!");
        System.out.println("Для полного бака нужно дозаправить - " +
                (way.vTank-way.balanceFuel)+ " на сумму " +  (way.vTank-way.balanceFuel)*money);
        countLitres = way.vTank - way.balanceFuel;
        way.refueling();
      System.out.println("Остановка в поселке Кривое озере для дозаправки. Остаток топлива - " + way.fuelBalance(stay_1));
        System.out.println("Требуется дозоправка - " + way.refuelingInRoad(stay_1));
        countLitres = countLitres + way.refuelingInRoad(stay_1);
      System.out.println("Остановка в поселке Кривое озере для дозаправки. Остаток топлива - " + way.fuelBalance(stay_2));
        System.out.println("Требуется дозоправка - " + way.refuelingInRoad(stay_2));
        countLitres = countLitres + way.refuelingInRoad(stay_2);
        way.refueling();
        System.out.println("Последний рывок!");
        System.out.println("Конечный пункт назначения г. Киев. Остаток топлива - " + way.fuelBalance(stay_3));
        countLitres = countLitres + way.refuelingInRoad(stay_3);
        System.out.println("Стоимость полной поездки составила - " + countLitres* money);

    }
}
