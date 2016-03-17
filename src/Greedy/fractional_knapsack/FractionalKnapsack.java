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

package Greedy.fractional_knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a set of items and total capacity of a knapsack,
 * finds the maximal value of fractions of items that fit
 * into the knapsack.
 */
public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        double value = 0;

        double[] weightValueRatio = new double[values.length];
        HashMap<Double, Integer> bag = new HashMap<>(values.length);

        for (int i = 0, n = values.length; i < n; i++) {
            weightValueRatio[i] = (double) values[i] / weights[i];
            bag.put(weightValueRatio[i], weights[i]);
        }

        // Sort to make this algorithm run in O(nLogn) time
        Arrays.sort(weightValueRatio);

        for (int i = values.length - 1; i > -1; i--) {
            if (capacity > 0) {
                double min = Math.min(capacity, bag.get(weightValueRatio[i]));
                value += min * weightValueRatio[i];
                capacity -= min;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
