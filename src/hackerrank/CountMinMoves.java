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

package hackerrank;

import java.util.Scanner;

/**
 *
 * You are given Q queries. Each query consists of a single number N. You can perform 2 operations on N in each move.
 * If N = a * b, (b != 1, a != 1) we can change N = max(a, b) or decrease the value of N by 1.

 Determine the minimum number of moves required to reduce the value of N to 0.

 Input Format

 The first line contains the integer Q.
 The next Q lines each contain an integer, N.

 Constraints
 1 <= Q <= 10^3
 0 <= N <= 10^6


 Output Format

 Output Q lines. Each line containing the minimum number of moves required to reduce the value of N to 0.

 Sample Input

 1
 3

 Sample Output

 3

 Explanation

 We only have one option that gives the minimum number of moves.
 Follow 3 -> 2 -> 1 -> 0. Hence, 3 moves.

 * Created by karataev on 7/16/16.
 */
public class CountMinMoves {

    private static int[] sMap = new int[1000002];

    private static int countMoves(int N) {

        if (N < 3) {
            sMap[N] = N;
            return N;
        } else {
            int min = Integer.MAX_VALUE;
            for(int i = 2; i * i <= N; i++) {
                if (N % i == 0) {
                    //System.out.println(i + " " + (N / i));
                    int max = N / i;
                    sMap[max] = (sMap[max] == 0) ? countMoves(max) : sMap[max];
                    if (sMap[max] < min) {
                        min = sMap[max];
                    }

                }
            }
            if (min != Integer.MAX_VALUE) {
                sMap[N - 1] = (sMap[N - 1] == 0) ? countMoves(N - 1) : sMap[N - 1];
                sMap[N] = Math.min(min, sMap[N - 1]) + 1;
                return sMap[N];
            } else {
                sMap[N-1] = (sMap[N-1] == 0)? countMoves(N-1): sMap[N-1];
                sMap[N] = sMap[N-1] + 1;
                return sMap[N];
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        for(int i = 0; i < sMap.length; i++) {
            sMap[i] = 0;
        }

        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for(int i = 0; i < Q; i++) {
            int N = sc.nextInt();
            System.out.println(countMoves(N));
        }
    }
}
