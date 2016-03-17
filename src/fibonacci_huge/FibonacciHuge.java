/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016.  Dmytro Karataiev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fibonacci_huge;

import java.util.*;

/**
 * Advanced Problem: Huge Fibonacci Number modulo m
 * Primitive implementation with calculating each fibonacci in iterative way (way too long)
 */
public class FibonacciHuge {

    private static HashMap<Long, Long> fibonacci;

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


        for (int i = 2; i < 5000; i++) {

            fibonacci.put((long) i, fib(i, m));

            if (fibonacci.get((long) i) == 1 && fibonacci.get((long) i - 1) == 0) {
                //System.out.println((i - 1) + " " + (i));
                return i - 1;
            }

        }

        return 0;
    }

    /**
     * Method to calculate fibonacci numbers
     *
     * @param n with constraints 0 <= n <= 45.
     * @return calculated fib number
     */
    private static long fib(int n, int m) {

        if (fibonacci.containsKey((long) n)) {
            return fibonacci.get((long) n);
        }

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
            sum[i] = (sum[i - 1] % m + sum[i - 2] % m) % m;
        }

        //System.out.println(sum[n]);
        return sum[n];
    }

    public static void main(String[] args) {

        fibonacci = new HashMap<>();
        fibonacci.put(0L, 0L);
        fibonacci.put(1L, 1L);

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        long huge = getFibonacciHuge(n, m);

        System.out.println("n: " + n + ", huge: " + huge);

        if (n < m) {
            System.out.println(fib((int) n, m));
            return;
        }
        long other = n % huge;
        System.out.println(fib((int) other, m));

    }

}

