package by.bsuir.lab1.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class Task8 {

    public static int[] merge(double[] sequence1, double[] sequence2) {
        int n = sequence1.length;
        int m = sequence2.length;
        int[] positions = new int[n + m];
        int i = 0, j = 0;
        int offset = 0;
        int bound = n - 1;
        while (i < bound) {
            if ((sequence1[i] <= sequence2[j]) && (sequence1[i + 1] > sequence2[j])) {
                positions[offset] = i + 1 + offset;
                j++;
                offset++;
            } else {
                i++;
            }
        }
        while (j < m) {
            positions[offset] = n + offset;
            j++;
            offset++;
        }
        return positions;
    }

    public static void main(String[] args) {
        // Read Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        System.out.println("Enter M:");
        int m = scanner.nextInt();
        double[] sequence1 = Task6.readDoubleArray(scanner, n);
        double[] sequence2 = Task6.readDoubleArray(scanner, m);
        // Merge
        int[] positions = merge(sequence1, sequence2);
        // Output
        System.out.println(Arrays.toString(positions));
    }
}