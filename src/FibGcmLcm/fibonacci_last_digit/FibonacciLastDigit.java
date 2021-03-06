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

package FibGcmLcm.fibonacci_last_digit;

import java.util.*;

/**
 * Algorithm to find the last digit of a large FibGcmLcm.fibonacci number.
 */
public class FibonacciLastDigit {

    /**
     * Method to calculate the last digit of a FibGcmLcm.fibonacci number.
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

