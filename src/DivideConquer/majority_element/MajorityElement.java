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

package DivideConquer.majority_element;

import java.util.*;
import java.io.*;

/**
 * Algorithm to calculate majority element in an array.
 * It works in O(n Log n) and returns either a majority element or -1 if it's not present.
 */
public class MajorityElement {

    private static int getMajorityElement(int[] a, int left, int right) {

        if (left > right) {
            return -1;
        } else if (left == right) {
            return a[left];
        } else {

            int median = (left + right) / 2;

            int one = getMajorityElement(a, left, median);
            int two = getMajorityElement(a, median + 1, right);
            if (one == two) {
                return one;
            }

            int half = (right - left + 1) / 2;

            if (one > -1) {
                if (getFrequency(a, left, right, one) > half) {
                    return one;
                }
            }
            if (two > -1) {
                if (getFrequency(a, left, right, two) > half) {
                    return two;
                }
            }
            return -1;
        }

    }

    private static int getFrequency(int[] a, int left, int right, int element) {
        int frequency = 0;

        for (int i = left; i <= right; i++) {
            if (a[i] == element) {
                frequency++;
            }
        }

        return frequency;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        //System.out.println(getMajorityElement(a, 0, a.length - 1));

        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

