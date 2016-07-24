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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *
 * In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, S. You must perform Q operations of the following 4 types:

 1. append(W) - Append string W to the end of S.
 2. delete(k) - Delete the last k characters of S.
 3. print(k) - Print the kth character of S.
 4. undo() - Undo the last (not previously undone) operation of type 1 or 2, reverting S to the state it was in prior to that operation.

 Input Format

 The first line contains an integer, Q, denoting the number of operations.
 Each line i of the Q subsequent lines (where 0 <= i < Q) defines an operation to be performed.
 Each operation starts with a single integer, t (where t belongs to {1, 2, 3, 4}),
 denoting a type of operation as defined in the Problem Statement above.
 If the operation requires an argument, t is followed by its space-separated argument.
 For example, if t = 1 and W = "abcd", line i will be 1 abcd.

 Constraints

 1 <= Q <= 10^5
 1 <= k <= |S|
 The sum of the lengths of all W in the input <= 10^6.
 All input characters are lowercase English letters.
 It is guaranteed that the sequence of operations given as input is possible to perform.

 Output Format

 Each operation of type 3 must print the kth character on a new line.

 Sample Input

 8
 1 abc
 3 3
 2 3
 1 xy
 3 2
 4
 4
 3 1

 Sample Output

 c
 y
 a

 Explanation

 Initially, S is empty. The following sequence of 8 operations are described below:

 1. S = "". We append abc to S, so S = "abc".
 2. Print the 3rd character on a new line. Currently, the 3rd character is c.
 3. Delete the last 3 characters in S(abc), so S = "".
 4. Append xy to S, so S = "xy".
 5. Print the 2nd character on a new line. Currently, the 2nd character is y.
 6. Undo the last update to S, making S empty again (i.e., S = "").
 7. Undo the next to last update to S (the deletion of the last 3 characters), making S = "abc".
 8. Print the 1st character on a new line. Currently, the 1st character is a.

 * Solved by karataev on 7/24/16.
 */
public class TextEditor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int queries = in.nextInt();

        Deque<Cache> deque = new ArrayDeque<>();

        String s = "";
        int last = -1;
        String cache = "";

        for (int i = 0; i < queries; i++) {
            int operation = in.nextInt();

            switch (operation) {
                case 1:
                    last = 1;
                    cache = in.nextLine().trim();
                    s += cache;
                    deque.addLast(new Cache(last, cache));
                    break;
                case 2:
                    int delete = in.nextInt();
                    last = 2;
                    cache = s.substring(s.length() - delete, s.length());
                    s = s.substring(0, s.length() - delete);
                    deque.addLast(new Cache(last, cache));
                    break;
                case 3:
                    System.out.println(s.charAt(in.nextInt() - 1));
                    break;
                case 4:
                    if (deque.peekLast().operation == 1) {
                        s = s.substring(0, s.length() - deque.peekLast().cache.length());
                        deque.pollLast();
                    } else {
                        s += deque.pollLast().cache;
                    }
                    break;
                default:
                    break;
            }

        }

        in.close();
    }

    private static class Cache {
        int operation;
        String cache;

        Cache(int op, String s) {
            operation = op;
            cache = s;
        }
    }
}