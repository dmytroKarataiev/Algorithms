package gcd;

import java.util.*;

/**
 * Algorithm to calculate greatest common divisor.
 */
public class GCD {

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

        System.out.println(gcd(a, b));
    }
}
