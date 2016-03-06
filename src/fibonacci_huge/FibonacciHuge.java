package fibonacci_huge;

import java.util.*;

/**
 * Advanced Problem: Huge Fibonacci Number modulo m
 */
public class FibonacciHuge {

    /**
     * Given two integers n and m, output Fn mod m
     * (that is, the remainder of Fn when divided by m)
     * Constraints: 1 <= n <= 10^18, 2 <= m <= 10^5.
     *
     * @param n first number
     * @param m second number
     * @return Fn mod m
     */
    private static long getFibonacciHuge(long n, int m) {

        long[] arrayOfFib = new long[2400];
        arrayOfFib[0] = 0;
        arrayOfFib[1] = 1;

        for (int i = 2; i < 2400; i++) {

            arrayOfFib[i] = (fib(i, m));

            if (arrayOfFib[i - 1] == 0 && arrayOfFib[i] == 1) {
                //System.out.println(Arrays.toString(arrayOfFib));
                //System.out.println("fib: " + (fib(i - 2, m)) + " i: " + (i - 1));
                return i - 1;
            }

        }

//        System.out.println(arrayOfFib[0]);
//        System.out.println(arrayOfFib[1]);
//
//        for (int i = 2310; i < 2330; i++) {
//            System.out.println(arrayOfFib[i]);
//        }

        return 0;
    }

    /**
     * Method to calculate fibonacci numbers
     *
     * @param n with constraints 0 <= n <= 45.
     * @return calculated fib number
     */
    private static long fib(int n, int m) {

        if (n < 0 || n > 450000) {
            return -1;
        }

        if (n <= 1) {
            return n;
        }

        long[] sum = new long[n + 1];
        sum[0] = 0;
        sum[1] = 1;

        for (int i = 2; i <= n; i++) {
            sum[i] = (sum[i - 1] + sum[i - 2]) % m;
        }
        //System.out.println("n + m " + n + " " + m + " " + sum[n]);

        return sum[n];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHuge(n, m));
        System.out.println(fib(1176, 30524));

    }

    private static long fib2(int n) {

        if (n < 0 || n > 450000) {
            return -1;
        }

        if (n <= 1) {
            return n;
        }

        long[] sum = new long[n + 1];
        sum[0] = 0;
        sum[1] = 1;

        for (int i = 2; i <= n; i++) {
            sum[i] = (sum[i - 1] + sum[i - 2]);
        }
        //System.out.println("n + m " + n + " " + m + " " + sum[n]);

        return sum[n];
    }
}

