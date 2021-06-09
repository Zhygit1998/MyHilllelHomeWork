package knb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyGame {
    static String path = System.getProperty("user.dir");
    static File myResFile = new File(path + "/" +"Result.txt");
    static File myLogFile = new File(path + "/" +"ToLog.txt");

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
        int finResUs = 0;
        int finResPC = 0;
        System.out.println("Ведите значения");
        System.out.println("k - камень");
        System.out.println("n - ножницы");
        System.out.println("b - бумага");
        System.out.println("x - что бы сдаться");
        String[] strRes = new String[countRound];
        String [] logWrite = new String[countRound];
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
            if (str[countPC][countUs].equals("PC")) {
                finResPC++;
            } else if (str[countPC][countUs].equals(name)) {
                finResUs++;
            } else {
            }
            String user = convertingNumberToString(countUs);
            String pc = convertingNumberToString(countPC);
            String strCount = i + 1 + " Round win: " + str[countPC][countUs];
            String detailRes = name + " выкинул " + user + ", Комьютер выкинул " + pc;
            System.out.println(strCount);
            System.out.println(detailRes);
            logWrite[i] = i + 1 + " round " + detailRes;
            strRes[i] = strCount;
        }
        String finalRes;
        if (finResPC>finResUs){
            finalRes = "По итогу " + countRound + " игр победил PC";
        }
        else if(finResUs>finResPC){
            finalRes = "По итогу " + countRound + " игр победил " + name;
        }
        else {
            finalRes = "По итогу " + countRound + " игр ничья";
        }
        System.out.println(finalRes);
        System.out.println("Результат " + countRound + " игр");
        try {
            writeToLog(logWrite);
            writeToResult(strRes, finalRes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultOfGames(strRes);
    }

    public static String convertingNumberToString(int conv) {
        String conver;
        switch (conv) {
            case 0:
                conver = "Камень";
                break;
            case 1:
                conver = "Ножницы";
                break;
            case 2:
                conver = "Бумага";
                break;
            default:
                conver = "Error";
                break;
        }
        return conver;
    }

    public static void resultOfGames(String[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static void writeToLog(String[] array) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(myLogFile));
        for (int i = 0; i < array.length; i++) {
            writer.write(String.valueOf(array[i]));
            writer.write(" ");
            writer.write("\r\n");
        }
        writer.flush();
    }

    public static void writeToResult(String[] array, String resFinal) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(myResFile));
        for (int i = 0; i < array.length; i++) {
            writer.write(String.valueOf(array[i]));
            writer.write(" ");
            writer.write("\r\n");
        }
        writer.write(String.valueOf(resFinal));
        writer.flush();
    }
}
