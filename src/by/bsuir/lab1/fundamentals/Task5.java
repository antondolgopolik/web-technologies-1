package by.bsuir.lab1.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    /*
    Finds the index of the largest number a: a <= n
     */
    public static int find(int[] numbers, int n) {
        int l = 0, r = numbers.length - 1;
        int m = 0;
        while (l <= r) {
            m = (r + l) / 2;
            if (numbers[m] > n) {
                r = m - 1;
            } else if (numbers[m] == n) {
                return m;
            } else {
                l = m + 1;
            }
        }
        return numbers[m] > n ? m - 1 : m;
    }

    public static int[] findLongestIncreasingSubsequence(int[] numbers) {
        int n = numbers.length;
        // DP array
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = numbers[0];
        // Length of LIS
        int max_length = 1;
        // To restore LIS
        int[] pointer = new int[n];
        int[] previous = new int[n];
        // Extract LIS
        for (int i = 1; i < n; i++) {
            int j = find(d, numbers[i]);
            int k = j + 1;
            if (((j == -1) || (d[j] != numbers[i])) && (d[k] > numbers[i])) {
                d[k] = numbers[i];
                pointer[k] = i;
                if (j != -1) {
                    previous[i] = pointer[k - 1];
                }
                if (k >= max_length) {
                    max_length = k + 1;
                }
            }
        }
        // Restore LIS
        int[] lis = new int[max_length];
        int ptr = pointer[max_length - 1];
        for (int i = max_length - 1; i >= 0; i--) {
            lis[i] = numbers[ptr];
            ptr = previous[ptr];
        }
        return lis;
    }

    public static void printOutput(int[] numbers, int[] lis) {
        System.out.println("Original sequence:");
        System.out.println(Arrays.toString(numbers));
        System.out.print("There are " + (numbers.length - lis.length) + " items to be removed. ");
        System.out.println("Then the following longest increasing subsequence will be obtained:");
        System.out.println(Arrays.toString(lis));
    }

    public static void main(String[] args) {
        // Read Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " integer numbers:");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        // Find LIS
        int[] lis = findLongestIncreasingSubsequence(numbers);
        // Output
        printOutput(numbers, lis);
    }
}
