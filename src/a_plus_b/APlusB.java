package a_plus_b;

import java.util.Scanner;

/**
 * First exercise from the Coursera Algorithmic Toolbox course.
 * Simple sum of two numbers to check if everything works correctly.
 */
class APlusB {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        while (a > 9 || a < 0) {
            a = s.nextInt();
        }

        int b = s.nextInt();
        while (b > 9 || b < 0) {
            b = s.nextInt();
        }

        System.out.println(a + b);

    }

}