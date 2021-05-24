package pseudographics;

import java.util.Arrays;
import java.util.Scanner;

public class Pseudographics {
    public static void main(String[] args) {
        pseudoPrint();
    }

    public static String[] pseudoСreature(String valueTrans) {
        switch (valueTrans) {
            case "0"-> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "@@  @@",
                        "@@  @@",
                        " @@@@ "};
            }
            case "1" -> {
                return new String[]{
                        "  @@  ",
                        " @@@  ",
                        "@ @@  ",
                        "  @@  ",
                        "@@@@@@"};

            }
            case "2" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "   @@ ",
                        " @@   ",
                        "@@@@@@"};
            }
            case "3" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "   @@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "4" -> {
                return new String[]{
                        "   @@ ",
                        "  @ @ ",
                        " @  @ ",
                        "@@@@@@",
                        "    @ "};
            }
            case "5" -> {
                return new String[]{
                        "@@@@@@",
                        "@@    ",
                        "@@@@@ ",
                        "    @@",
                        "@@@@@ "};
            }
            case "6" -> {
                return new String[]{
                        " @@@@ ",
                        "@@    ",
                        "@@@@@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "7" -> {
                return new String[]{
                        "@@@@@@",
                        "   @@ ",
                        "  @@  ",
                        " @@   ",
                        "@@    "};
            }
            case "8" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        " @@@@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "9" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        " @@@@@",
                        "    @@",
                        " @@@@ "};
            }
            default -> {
                return new String[]{"error"};
            }
        }
    }

    public static void pseudoPrint() {
        System.out.println("Привет! Это приложение выводит псевдографикой на экран заданые числа в диапазоне от 1000 до 10000");
        System.out.println("Введите заданое число в консоль");
        Scanner scanner = new Scanner(System.in);
        String str  = scanner.nextLine();
        String [] strArr = String.valueOf(str).split("");
        String[] strCol = {"", "", "", "", ""};
        String[] tempArr;
        for (int i = 0; i <strArr.length ; i++) {
            tempArr = pseudoСreature(strArr[i]);
            for (int j = 0; j < strCol.length; j++) {
                strCol[j] = strCol[j] + "  " +tempArr[j];
            }
        }
        Arrays.stream(strCol).forEach(System.out::println);
    }
}
