package by.bsuir.lab1.fundamentals;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        double a = scanner.nextDouble();
        System.out.println("Enter b:");
        double b = scanner.nextDouble();
        System.out.println("Enter h:");
        double h = scanner.nextDouble();
        System.out.println("Table:");
        printTable(a, b, h);
    }

    public static void printTable(double a, double b, double h) {
        while (a <= b) {
            System.out.printf("tg(%f) = %f\n", a, Math.tan(a));
            a += h;
        }
    }
}
