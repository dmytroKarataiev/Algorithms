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

import java.util.HashMap;
import java.util.Scanner;

/**
 * There are N strings. Each string's length is no more than 20 characters.
 * There are also Q queries. For each query, you are given a string,
 * and you need to find out how many times this string occurred previously.
 *
 * Input Format:
 * The first line contains N, the number of strings.
 * The next N lines each contain a string.
 * The N + 2nd line contains Q, the number of queries.
 * The following Q lines each contain a query string.
 *
 * Constraints:
 * 1 <= Q <= 10000
 * 1 <= N <= 10000
 * 1 <= length of any String <= 20
 *
 * Sample Input:
 * 4
 * aba
 * baba
 * aba
 * xzxb
 * 3
 * aba
 * xzxb
 * ab
 *
 * Sample Output:
 * 2
 * 1
 * 0
 *
 * Explanation
 * Here, "aba" occurs twice, in the first and third string.
 * The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
 *
 * Created by karataev on 7/13/16.
 */
public class SparseArr {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        in.nextLine();

        HashMap<String, Integer> map = new HashMap<>(size);

        for (int i = 0; i < size; i++) {
            String key = in.nextLine();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        int queries = in.nextInt();
        in.nextLine();

        for (int i = 0; i < queries; i++) {
            String key = in.nextLine();
            int num = map.containsKey(key) ? map.get(key) : 0;
            System.out.println(num);
        }

        in.close();
    }

}
