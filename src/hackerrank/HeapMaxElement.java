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

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * You have an empty sequence, and you will be given  queries. Each query is one of these three types:
 * <p>
 * 1 x  -Push the element x into the stack.
 * 2    -Delete the element present at the top of the stack.
 * 3    -Print the maximum element in the stack.
 * Input Format:
 * The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)
 * <p>
 * Constraints
 * 1 <= N <= 10^5
 * 1 <= x <= 10^9
 * 1 <= type <= 3
 * * Output Format
 * For each type  query, print the maximum element in the stack on a new line.
 * <p>
 * Sample Input
 * 10
 * 1 97
 * 2
 * 1 20
 * 2
 * 1 26
 * 1 20
 * 2
 * 3
 * 1 91
 * 3
 * Sample Output
 * 26
 * 91
 * <p>
 * Created by karataev on 7/13/16.
 */
public class HeapMaxElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int queries = in.nextInt();
        in.nextLine();

        Stack<Integer> sc = new Stack<>();
        PriorityQueue<Integer> prior = new PriorityQueue<>(queries, Collections.reverseOrder());

        for (int i = 0; i < queries; i++) {
            int operation = in.nextInt();

            switch (operation) {
                case 1:
                    int element = in.nextInt();
                    prior.add(element);
                    sc.push(element);
                    break;
                case 2:
                    prior.remove(sc.peek());
                    sc.pop();
                    break;
                case 3:
                    System.out.println(prior.peek());
                    break;
            }

        }

        in.close();

    }
}
