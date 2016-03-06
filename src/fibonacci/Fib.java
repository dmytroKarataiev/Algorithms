package fibonacci;

import java.util.Scanner;

/**
 * Simple iterative Fibonacci implementation
 */
public class Fib {

    /**
     * Method to calculate fibonacci numbers
     * @param n with constraints 0 <= n <= 45.
     * @return calculated fib number
     */
    private static long fib(int n) {

        if (n < 0 || n > 45) {
            return -1;
        }

        if (n <= 1) {
            return n;
        }

        int[] sum = new int[n + 1];
        sum[0] = 0;
        sum[1] = 1;

        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }

        return sum[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(fib(n));
    }
}
