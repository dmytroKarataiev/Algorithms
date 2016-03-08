package fibonacci_huge;

import java.util.Scanner;

/**
 * Class to calculate huge Fibonacci number mod another huge number,
 * using <a href="https://en.wikipedia.org/wiki/Exponentiation_by_squaring">
 *     exponentiation by squaring method.</a>
 *
 * Created by karataev on 3/7/16.
 */
public class FibonacciSquare {

    /**
     * Method to calculate fibonacci using exponentiation by squaring
     * @param n power
     * @return Fibonacci mod
     */
    private static long fibonacci(long n, long mod) {

        long F[][] = {
                {1, 1},
                {1, 0} };

        if (n == 0) {
            return 0;
        }

        power(F, n - 1, mod);

        return F[0][0];
    }

    /**
     * Recursive exponentiation method
     * @param fibMatrix fibonacci matrix
     * @param power to which exponentiation should be made
     */
    private static void power(long fibMatrix[][], long power, long mod) {

        if (power <= 1) {
            return;
        }

        long matrix[][] = {
                {1, 1},
                {1, 0} };

        power(fibMatrix, power / 2, mod);

        multiply(fibMatrix, fibMatrix, mod);

        if (power % 2 != 0) {
            multiply(fibMatrix, matrix, mod);
        }
    }

    /**
     * Matrix multiplication
     * @param fFibonacci initial matrix
     * @param mFibonacci either copy, or another matrix
     */
    private static void multiply(long fFibonacci[][], long mFibonacci[][], long mod) {

        // Modulo distributive property: (fib1 + fib2) % mod == (fib1 % mod + fib2 % mod) % mod
        long x = ((fFibonacci[0][0] * mFibonacci[0][0]) % mod + (fFibonacci[0][1] * mFibonacci[1][0]) % mod) % mod;
        long y = ((fFibonacci[0][0] * mFibonacci[0][1]) % mod + (fFibonacci[0][1] * mFibonacci[1][1]) % mod) % mod;
        long z = ((fFibonacci[1][0] * mFibonacci[0][0]) % mod + (fFibonacci[1][1] * mFibonacci[1][0]) % mod) % mod;
        long w = ((fFibonacci[1][0] * mFibonacci[0][1]) % mod + (fFibonacci[1][1] * mFibonacci[1][1]) % mod) % mod;

        fFibonacci[0][0] = x;
        fFibonacci[0][1] = y;
        fFibonacci[1][0] = z;
        fFibonacci[1][1] = w;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long mod = scanner.nextLong();

        System.out.println(fibonacci(n, mod));
    }
}
