package HomeWorkThird;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkThird {
    public static int uneven = 100;

    public static void main(String[] args) {
        uneven();
        factorial();
        remakeTaskFirst();
        remakeTaskSecond();
        remakeTaskFourth();
        remakeTaskFifth();
        rate();
        sequence();
        multiplicationTable();
        array();
        arrayNumberMin();
        chess();
    }

    public static void uneven() {
        System.out.println("Task 1");//При помощи цикла for вывести на экран нечетные числа от 1 до 99.
        for (int i = 1; i <= uneven; i++) {
            if (i % 2 != 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public static void factorial() {
        System.out.println("Task 2");//Дано число n при помощи цикла for посчитать факториал n!
        System.out.println("Введтите число, факториал которого желаете найти");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        System.out.println("Факториал числа " + n + " = " + result);
    }

    public static void remakeTaskFirst() {
        System.out.println("Task 3.1");//Перепишите программы с использованием цикла while.
        int i = 1;
        while (i != uneven) {
            if (i % 2 != 0) {
                System.out.print(i + ", ");
            }
            i++;
        }
        System.out.println();
    }

    public static void remakeTaskSecond() {
        System.out.println("Task 3.2");//Перепишите программы с использованием цикла while.
        System.out.println("Введтите число, факториал которого желаете найти");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = 0;
        int count = 1;
        while (result != n) {
            count = (n - result) * count;
            result++;
        }
        System.out.println("Факториал числа " + n + " = " + count);
        System.out.println();
    }

    public static void remakeTaskFourth() {
        System.out.println("Task 4.1");//Перепишите программы с использованием цикла do - while.
        int i = 1;
        do {
            if (i % 2 != 0) {
                System.out.print(i + ", ");
            }
            i++;
        }
        while (i < uneven);
        System.out.println();
    }

    public static void remakeTaskFifth() {
        System.out.println("Task 4.2");//Перепишите программы с использованием цикла do - while.
        System.out.println("Введтите число, факториал которого желаете найти");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = 0;
        int count = 1;
        do {
            count = (n - result) * count;
            result++;
        }
        while (result != n);
        System.out.println("Факториал числа " + n + " = " + count);
    }

    public static void rate() {
        System.out.println("Task 5");//Даны переменные x и n вычислить x^n
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число возводимое в степень");
        int x = scan.nextInt();
        System.out.println("Введите степень возводимого число");
        int n = scan.nextInt();
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (n == 1) {
                count = 1;
            } else {
                count = count * x;
            }
        }
        System.out.println("Число " + x + ", в степени " + n + " = " + count);
    }

    public static void sequence() {
        System.out.println("Task 6");//Вывести 10 первых чисел последовательности 0, -5,-10,-15..
        int count = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print(count + ", ");
            count -= 5;
        }
        System.out.println();

    }

    public static void multiplicationTable() {
        System.out.println("Task 7");//Необходимо вывести на экран таблицу умножения на Х: (любое число вводимое из консоли)
        Scanner scan = new Scanner(System.in);
        System.out.println("Таблица умножения. Введите число");
        int x = scan.nextInt();
        for (int i = 1; i < 10; i++) {
            int count = x * i;
            System.out.println(x + "x" + i + " = " + count);
        }
    }

    public static void array() {
        System.out.println("Task 8");//Создайте массив, содержащий 10 первых нечетных чисел. Выведете элементы массива на консоль в одну строку, разделяя запятой.
        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = 2 * i + 1;
        System.out.print(Arrays.toString(array));
        System.out.println();
    }

    public static void arrayNumberMin() {
        System.out.println("Task 9, 10, 11, 12");
        //Дан массив размерности N, найти наименьший элемент массива и вывести на консоль (если наименьших элементов несколько — вывести их все).
        int n = 10;
        int[] randomArray;
        randomArray = new int[n];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (1 + (Math.random() * 100));
        }
        System.out.println("Заданый рандомно массив");
        System.out.println(Arrays.toString(randomArray));
        int min = randomArray[0];
        int max = randomArray[0];
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < min) {
                min = randomArray[i];
            }
            if (randomArray[i] > max) {         //В массиве из задания 9. найти наибольший элемент.
                max = randomArray[i];
            }
        }
        for (int i = 0; i < randomArray.length; i++) {
            if (min == randomArray[i]) {
                System.out.println("Минимальные значения в массиве - " + min);
            }
        }
        System.out.println("Максимальное значение в массиве - " + max);
        System.out.println(Arrays.toString(randomArray));
        for (int i = 0; i < randomArray.length; i++) {
            //Поменять наибольший и наименьший элементы массива местами.
            if (randomArray[i] == min) {
                if (randomArray[i] == max) {
                    randomArray[i] = min;
                }
                if (randomArray[i] == min) {
                    randomArray[i] = max;
                }
            } else {
                if (randomArray[i] == max) {
                    randomArray[i] = min;
                }

            }
        }
        System.out.println("Замена наименьше и наибольшего элементов массива местами");
        System.out.println(Arrays.toString(randomArray));
        //Найти среднее арифметическое всех элементов массива.
        double average = 0;
        if (randomArray.length > 0) {
            double sum = 0;
            for (int i = 0; i < randomArray.length; i++) {
                sum += randomArray[i];
            }
            average = sum / randomArray.length;
            System.out.println("Среднее арифметическое элементов массива = " + average);
        }
    }

    public static void chess() {
        System.out.println("Task 13 (Final)");//(*)Вывести на экран шахматную доску 8х8 в виде 2 мерного массива (W - белые клетки , B - черные клети)
        String[][] arrayChess = new String[8][8];
        for (int i = 0; i < arrayChess.length; i++) {
            for (int j = 0; j < arrayChess[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    arrayChess[i][j] = "W";
                } else {
                    arrayChess[i][j] = "B";

                }
                System.out.print(arrayChess[i][j] + " ");
            }
            System.out.println();
        }
    }
}

