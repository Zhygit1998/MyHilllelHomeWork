package KMNB;

import java.util.Arrays;
import java.util.Scanner;

public class MyNewGame {
    public static void main(String[] args) {
        playM();
    }

    public static void playM() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свое имя");
        String name = scanner.nextLine();
        System.out.println("Введите колличество партий");
        int countRound = scanner.nextInt();
        playRes(countRound, name);
    }

    public static void playRes(int countRound, String name) {
        System.out.println("Ведите значения");
        System.out.println("k - камень");
        System.out.println("n - ножницы");
        System.out.println("b - бумага");
        System.out.println("x - что бы сдаться");
        String[] strRes = new String[countRound];
        Scanner scanner = new Scanner(System.in);
        outer:
        for (int i = 0; i < countRound; i++) {
            String res = scanner.nextLine();
            res.toLowerCase();
            int countUs, countPC;
            countUs = 0;
            countPC = (int) (Math.random() * 2);
            switch (res) {
                case "k":
                    break;
                case "n":
                    countUs = 1;
                    break;
                case "b":
                    countUs = 2;
                    break;
                case "x":
                    System.out.println("Вы закончили игру преждевременно");
                 resultOfGames(strRes);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введено неверное значение. Будьте внимательней");
                    i--;
                    continue outer;
            }
            String[][] str = {
                    {"Ничья", "PC", name},
                    {name, "Ничья", "PC"},
                    {"PC", name, "Ничья"}};
            String strCount = str[countPC][countUs];
            System.out.println("This round win: " + strCount);
            strRes[i] = i + 1 + " Round win: " + strCount;
        }
        System.out.println("Результат " + countRound + " игр");
        resultOfGames(strRes);
    }

    public static void resultOfGames(String[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}