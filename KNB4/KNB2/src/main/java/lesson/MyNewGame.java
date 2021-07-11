package lesson;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class MyNewGame {
    static String path = System.getProperty("user.dir");
    static File myResFile = new File(path + "/" + "Result.txt");
    static File myLogFile = new File(path + "/" + "ToLog.txt");
    private static final Logger log = Logger.getLogger(MyNewGame.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("Choose language");
        System.out.println("1- English");
        System.out.println("2- Русский");
        System.out.println("3- Українська");
        ResourceBundle bundleLang;
        Scanner scanner = new Scanner(System.in);
        int change = scanner.nextInt();
        switch (change) {
            case 1:
                ResourceBundle bundle_en = ResourceBundle.getBundle("translate", new Locale("en", "US"));
                bundleLang = bundle_en;
                break;
            case 2:
                ResourceBundle bundleDef = ResourceBundle.getBundle("translate");
                bundleLang = bundleDef;
                break;
            case 3:
                ResourceBundle bundle_ua = ResourceBundle.getBundle("translate", new Locale("ua", "ua"));
                bundleLang = bundle_ua;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + change);
        }
        log.info("Пользователь вошел в игру");
        playM(bundleLang);
    }

    public static void playM(ResourceBundle bundle) throws UnsupportedEncodingException {
        System.out.println(new String(bundle.getString("message_1").getBytes("ISO-8859-1"), "cp1251"));
        Scanner scanner = new Scanner(System.in);
        System.out.println(new String(bundle.getString("message_2").getBytes("ISO-8859-1"), "cp1251"));
        String name = scanner.nextLine();
        log.info("Имя пользователя - " + name); //Задание на свое усмотрение
        System.out.println(new String(bundle.getString("message_3").getBytes("ISO-8859-1"), "cp1251"));
        int countRound = scanner.nextInt();
        log.info("Пользователь выбрал " + countRound + " партий");
        playRes(countRound, name, bundle);
    }

    public static void playRes(int countRound, String name, ResourceBundle bundle) throws UnsupportedEncodingException {
        int finResUs = 0;
        int finResPC = 0;
        System.out.println(new String(bundle.getString("message_4").getBytes("ISO-8859-1"), "cp1251"));
        System.out.println("k - " + new String(bundle.getString("message_5").getBytes("ISO-8859-1"), "cp1251"));
        System.out.println("n - " + new String(bundle.getString("message_6").getBytes("ISO-8859-1"), "cp1251"));
        System.out.println("b - " + new String(bundle.getString("message_7").getBytes("ISO-8859-1"), "cp1251"));
        System.out.println("x - " + new String(bundle.getString("message_18").getBytes("ISO-8859-1"), "cp1251"));
        String[] strRes = new String[countRound];
        String[] logWrite = new String[countRound];
        Scanner scanner = new Scanner(System.in);
        outer:
        for (int i = 0; i < countRound; i++) {
            log.info("Сыграно партий " + i);
            log.info("Оасталось партий " + (countRound - i));
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
                    System.out.println(new String(bundle.getString("message_8").getBytes("ISO-8859-1"), "cp1251"));
                    resultOfGames(strRes);
                    log.info("Пользователь преждевременно завершил игру, сыграв " + i++ + " партий");
                    System.exit(0);
                    break;
                default:
                    System.out.println(new String(bundle.getString("message_9").getBytes("ISO-8859-1"), "cp1251"));
                    log.error("Пользователь ввел неверное значение");
                    i--;
                    continue outer;
            }
            String resBundle = new String(bundle.getString("message_10").getBytes("ISO-8859-1"), "cp1251");
            String[][] str = {
                    {resBundle, "PC", name},
                    {name, resBundle, "PC"},
                    {"PC", name, resBundle}};
            if (str[countPC][countUs].equals("PC")) {
                finResPC++;
            } else if (str[countPC][countUs].equals(name)) {
                finResUs++;
            } else {
            }
            String user = convertingNumberToString(countUs, bundle);
            String pc = convertingNumberToString(countPC, bundle);
            String strCount = i + 1 + new String(bundle.getString("message_11").getBytes("ISO-8859-1"), "cp1251")
                    + str[countPC][countUs];
            String detailRes = name + new String(bundle.getString("message_12").getBytes("ISO-8859-1"), "cp1251")
                    + user + " PC" + new String(bundle.getString("message_12").getBytes("ISO-8859-1"), "cp1251") + pc;
            log.info(strCount + " ---> " + detailRes);
            System.out.println(strCount);
            System.out.println(detailRes);
            logWrite[i] = i + 1 + new String(bundle.getString("message_11").getBytes("ISO-8859-1"), "cp1251") + detailRes;
            strRes[i] = strCount;
        }
        String finalRes;
        if (finResPC > finResUs) {
            finalRes = new String(bundle.getString("message_13").getBytes("ISO-8859-1"), "cp1251") + " "
                    + countRound + " " + new String(bundle.getString("message_14").getBytes("ISO-8859-1"), "cp1251") + " PC";
        } else if (finResUs > finResPC) {
            finalRes = new String(bundle.getString("message_13").getBytes("ISO-8859-1"), "cp1251") + " " +
                    countRound + " " + new String(bundle.getString("message_14").getBytes("ISO-8859-1"), "cp1251") + " " +name;
        } else {
            finalRes = new String(bundle.getString("message_13").getBytes("ISO-8859-1"), "cp1251") + " " +
                    countRound + " " + new String(bundle.getString("message_15").getBytes("ISO-8859-1"), "cp1251") ;
        }
        System.out.println(finalRes);
        System.out.println(new String(bundle.getString("message_16").getBytes("ISO-8859-1"), "cp1251")+ " " +countRound + " " +
                new String(bundle.getString("message_17").getBytes("ISO-8859-1"), "cp1251"));
        try {
            writeToLog(logWrite);
            writeToResult(strRes, finalRes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Игра окончена. Победил - " + finalRes);
        resultOfGames(strRes);
    }

    public static String convertingNumberToString(int conv, ResourceBundle bundle) throws UnsupportedEncodingException {
        String conver;
        switch (conv) {
            case 0:
                conver = new String(bundle.getString("message_5").getBytes("ISO-8859-1"), "cp1251");
                break;
            case 1:
                conver = new String(bundle.getString("message_6").getBytes("ISO-8859-1"), "cp1251");
                break;
            case 2:
                conver = new String(bundle.getString("message_7").getBytes("ISO-8859-1"), "cp1251");
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