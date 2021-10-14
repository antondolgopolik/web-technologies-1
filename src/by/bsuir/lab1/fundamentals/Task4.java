package by.bsuir.lab1.fundamentals;

import java.util.*;

public class Task4 {

    public static void main(String[] args) {
        // Read input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " positive integer numbers:");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        // Find prime numbers
        List<Integer> primeNumberIndexes = findPrimeNumberIndexes(numbers);
        // Print prime numbers indexes (starting from 1)
        printPrimeNumberIndexes(primeNumberIndexes);
    }

    public static List<Integer> findPrimeNumberIndexes(int[] numbers) {
        List<Integer> primeNumberIndexes = new LinkedList<>();
        for (int i = 0; i <= numbers.length; i++) {
            if (isPrime(numbers[i], 10)) {
                primeNumberIndexes.add(i + 1);
            }
        }
        return primeNumberIndexes;
    }

    public static void printPrimeNumberIndexes(List<Integer> primeNumberIndexes) {
        System.out.println("Prime number indexes:");
        for (Integer primeNumberIndex : primeNumberIndexes) {
            System.out.println(primeNumberIndex + " ");
        }
    }

    public static boolean isPrime(int n, int k) {
        // Special cases
        if (n == 1) {
            return false;
        }
        if ((n == 2) || (n == 3)) {
            return true;
        }
        if ((n % 2) == 0) {
            return false;
        }
        // Miller-Rabin primality test
        int r = 0, d = n - 1;
        while ((d & 1) != 1) {
            r++;
            d >>= 1;
        }
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int a = 2 + random.nextInt(n - 3);
            int x = modPow(a, d, n);
            if ((x == 1) || (x == (n - 1))) {
                continue;
            }
            boolean isComposite = true;
            for (int j = 1; j < r; j++) {
                int y = modPow(x, 2, n);
                if (y == 1) {
                    return false;
                }
                if (y == (n - 1)) {
                    isComposite = false;
                    break;
                }
            }
            if (isComposite) {
                return false;
            }
        }
        return true;
    }

    public static int modPow(int x, int y, int m) {
        if (y == 1) {
            return x % m;
        }
        long temp = modPow(x, y / 2, m);
        temp = temp * temp % m;
        if ((y % 2) != 0) {
            temp = temp * x % m;
        }
        return (int) temp;
    }
}
