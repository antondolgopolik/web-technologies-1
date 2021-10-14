package by.bsuir.lab1.fundamentals;

import java.util.Scanner;

public class Task6 {

    public static double[] readDoubleArray(Scanner scanner, int n) {
        System.out.println("Enter " + n + " real numbers:");
        double[] numbers = new double[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }
        return numbers;
    }

    public static double[][] prepareMatrix(double[] numbers) {
        int n = numbers.length;
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (int k = i; k < n; k++) {
                matrix[i][j] = numbers[k];
                j++;
            }
            for (int k = 0; k < i; k++) {
                matrix[i][j] = numbers[k];
                j++;
            }
        }
        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double cell : row) {
                System.out.printf("%10.4f", cell);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Read Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        double[] numbers = readDoubleArray(scanner, n);
        // Prepare matrix
        double[][] matrix = prepareMatrix(numbers);
        // Output
        printMatrix(matrix);
    }
}
