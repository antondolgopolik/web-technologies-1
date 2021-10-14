package by.bsuir.lab1.fundamentals;

import java.util.Scanner;

import static java.lang.Math.*;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x:");
        double x = scanner.nextDouble();
        System.out.println("Enter y:");
        double y = scanner.nextDouble();
        System.out.println("Result:\n" + f(x, y));
    }

    public static double f(double x, double y) {
        return (1 + pow(sin(x + y), 2)) / (2 + abs(x - 2 * x / (1 + pow(x * y, 2)))) + x;
    }
}
