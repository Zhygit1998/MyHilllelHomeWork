package lesson2;

import java.util.Scanner;

public class Deposit {
    public static float sumInitial;
    private static double percent;
    private static int years;
    private static int month = 12;

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму вклада по депозиту ----> " );
        sumInitial = scan.nextFloat();
        System.out.println("Введите желаемый процент годовых по депозиту ----> ");
        percent = scan.nextDouble();
        System.out.println("Укажите длительность вклада по депозиту в годах ----> ");
        years = scan.nextInt();
        Deposit deposit = new Deposit();
        deposit.resultDeposit();
    }

    public void resultDeposit() {
        float sum = sumInitial;
        System.out.println("Депозит в размере " + sum + " гривен под " + percent + " годовых на " + years + " лет:");
        for (int i = 1; i < years + 1; i++) {
            for (int j = 1; j <= month; j++) {
                sum += sum * (percent/month)/ 100;
                System.out.println(j + " Месяц - " + sum);
            }
            System.out.println("Год - " + i + ". Сумма: " + + sum + " гривен");
            System.out.println("Начислиные проценты за " + i + " год составили - " + (sum-sumInitial));
        }
        System.out.println("За " + years + " лет вы получили " + sum + " гривен");
    }
}
