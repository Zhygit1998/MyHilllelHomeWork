package lesson_10;

import java.util.Scanner;

public class RootsQuadraticEquation {
    public static void main(String[] args) {
        double a, b, c, D;
        Scanner in = new Scanner(System.in);
        System.out.println("Решение квадратного уравнения вида ax^2 + bx + c = 0");
        System.out.println("Ведите значение a");
        a= in.nextDouble();
        System.out.println("Ведите значение b");
        b = in.nextDouble();
        System.out.println("Ведите значение c");
        c = in.nextDouble();
        D=b*b-4*a*c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет лишь один корень: x = " + x);
        }
        else {
            System.out.println("Корней нет");
        }
    }
}
