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

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value K.
 * To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:
 * <p>
 * sweetness = (1 * Least sweet cookie + 2 * 2nd least sweet cookie).
 * <p>
 * He repeats this procedure until all the cookies in his collection have a sweetness >= K.
 * You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness >= K.
 * Print -1 if this isn't possible.
 * <p>
 * Input Format
 * <p>
 * The first line consists of integers N, the number of cookies and K, the minimum required sweetness, separated by a space.
 * The next line contains N integers describing the array A where A_i is the sweetness of the ith cookie in Jesse's collection.
 * <p>
 * Constraints
 * 1 <= N <= 10^6
 * 0 <= K <= 10^9
 * 0 <= A_i <= 10^6
 * Output Format
 * <p>
 * Output the number of operations that are needed to increase the cookie's sweetness >= K.
 * Output -1 if this isn't possible.
 * <p>
 * Sample Input
 * 6 7
 * 1 2 3 9 10 12
 * <p>
 * Sample Output
 * 2
 * <p>
 * Explanation
 * Combine the first two cookies to create a cookie with sweetness = 1 * 1 + 2 * 2 = 5
 * After this operation, the cookies are 3, 5, 9, 10, 12.
 * Then, combine the cookies with sweetness 3 and sweetness 5, to create a cookie with resulting sweetness = 1 * 3 + 2 * 5 = 13.
 * Now, the cookies are 9, 10, 12, 13.
 * All the cookies have a sweetness >= 7.
 * <p>
 * Thus, 2 operations are required to increase the sweetness.
 * <p>
 * Created by karataev on 7/13/16.
 */
public class JesseCookies {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int cookies = in.nextInt();
        int sweetness = in.nextInt();

        PriorityQueue<Integer> prior = new PriorityQueue<>(cookies);

        while (in.hasNext()) {
            prior.add(in.nextInt());
        }

        int iterations = 0;

        while (prior.peek() != null && prior.peek() < sweetness && prior.size() > 1) {

            int first = prior.poll();
            int second = prior.poll();
            prior.add(first + 2 * second);

            iterations++;

        }

        if (prior.peek() != null && prior.peek() >= sweetness) {
            System.out.println(iterations);
        } else {
            System.out.println(-1);
        }


        in.close();
    }
}
