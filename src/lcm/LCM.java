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

package lcm;

import java.util.*;

/**
 * Least Common Multiple algorithm
 */
public class LCM {

    /**
     * Method to calculate the least common multiple.
     * Constraints: 1 <= a, b <= 2 * 10^9
     * @param a first number
     * @param b second number
     * @return least common multiple of a and b
     */
    private static long lcm(int a, int b) {

        if (a < 1 || b < 1 || a > 2e9 || b > 2e9) {
            return -1;
        }

        return ((long) a * b) / gcd(a, b);
    }

    /**
     * Method to calculate the Greatest Common Divisor using Euclid algorithm
     * Constraints: 1 <= a, b <= 2 * 10^9
     * @param a first number
     * @param b second number
     * @return GCD of a and b
     */
    private static int gcd(int a, int b) {

        if (a < 1 || b < 0 || a > 2e9 || b > 2e9) {
            return -1;
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
