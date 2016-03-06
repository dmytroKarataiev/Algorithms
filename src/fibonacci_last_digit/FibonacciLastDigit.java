package fibonacci_last_digit;

import java.util.*;

/**
 * Algorithm to find the last digit of a large fibonacci number.
 */
public class FibonacciLastDigit {

    /**
     * Method to calculate the last digit of a fibonacci number.
     * @param n with constraints 0 <= n <= 10^7
     * @return last digit of the fib number
     */
    private static int getFibonacciLastDigit(int n) {

        if (n < 0 || n > 10e7) {
            return -1;
        }

        if (n <= 1) {
            return n;
        }

        int[] sum = new int[n + 1];
        sum[0] = 0;
        sum[1] = 1;

        for (int i = 2; i <= n; i++) {
            sum[i] = (sum[i - 1] + sum[i - 2]) % 10;
        }

        return sum[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

