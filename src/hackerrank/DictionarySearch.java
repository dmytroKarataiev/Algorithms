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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * We are going to make our own contacts application.
 * You are given the number of operations to perform, N.
 * In any contacts application, two basic operations are add and find.
 * The input will be one of the following:

 1. add name
 2. find partial

 For the find operation, you will have to print the number of
 contacts who have a name starting with that partial name.

 Input Format

 The first line contains the integer N, the number of operations to be performed.
 The next N lines contains one of the two operations defined above.

 Constraints
 1 <= N <= 10^5
 1 <= Length(name) <= 21
 1 <= Length(partial) <= 21

 The entire input consists of lowercase characters only.

 Output Format

 For each operation of type find partial, print the number of contacts starting with the string partial.

 Sample Input

 4
 add hack
 add hackerrank
 find hac
 find hak

 Sample Output

 2
 0

 Explanation

 The names hack and hackerrank both start with the string hac.
 We have no name starting with the string hak.

 * Created by karataev on 7/15/16.
 */
public class DictionarySearch {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int ops = Integer.parseInt(br.readLine());

        for (int i = 0; i < ops; i++) {

            String[] func = br.readLine().split(" ");

            if (func[0].equals("add")) {

                for (int j = 1; j <= func[1].length(); j++) {
                    String key = func[1].substring(0, j);

                    if (map.get(key) == null) {
                        map.put(key, 1);
                    } else {
                        map.put(key, map.get(key) + 1);
                    }
                }
            } else {

                if (map.get(func[1]) == null) {
                    System.out.println(0);
                } else {
                    System.out.println(map.get(func[1]));
                }

            }

        }

    }

}
