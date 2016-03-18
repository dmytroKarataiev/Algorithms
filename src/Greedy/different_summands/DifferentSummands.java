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

package Greedy.different_summands;

import java.util.*;

/**
 * Represents a given positive integer n as a sum of as many pairwise
 * distinct positive integers as possible. That is, finds the maximum k such that n can be written as
 * a1 + a2 + · · · + ak where a1, . . . , ak are positive integers and ai 6= aj for all 1 ≤ i < j ≤ k.
 */
public class DifferentSummands {

    private static List<Integer> recursiveSummands = new ArrayList<>();

    /**
     * Iterative solution, works without StackOverflow
     * @param k initial number
     */
    private static List<Integer> optimalSummands(int k) {

        List<Integer> summands = new ArrayList<>();

        int l = 1;
        while (k > 2 * l) {
            summands.add(l);
            k -= l;
            l++;
        }
        summands.add(k);

        return summands;
    }

    /**
     * Recursive implementation, works up until l <= 10^7
     * @param k initial number
     * @param l distinct summand
     */
    private static void recursiveSummands(int k, int l) {

        if (k <= 2 * l) {
            recursiveSummands.add(k);
        } else {
            recursiveSummands.add(l);
            recursiveSummands(k - l, l + 1);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> summands = optimalSummands(n);

        System.out.println(summands.size());

        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

