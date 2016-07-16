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

/**
 *
 * The median of a set of integers is the midpoint value of the data set
 * for which an equal number of integers are less than and greater than the value.
 * To find the median, you must first sort your set of integers in non-decreasing order, then:

 If your set contains an odd number of elements, the median is the middle element of the sorted sample.
 In the sorted set {1, 2, 3}, 2 is the median.

 If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample.
 In the sorted set {1, 2, 3, 4}, (2 + 3) / 2 = 2.5 is the median.

 Given an input stream of n integers, you must perform the following task for each ith integer:

 1. Add the ith integer to a running list of integers.
 2. Find the median of the updated list (i.e., for the first element through the ith element).
 3. Print the list's updated median on a new line.
 The printed value must be a double-precision number scaled to 1 decimal place (i.e., 12.3 format).

 Input Format

 The first line contains a single integer, n, denoting the number of integers in the data stream.
 Each line i of the n subsequent lines contains an integer, a_i, to be added to your list.

 Constraints
 1 <= n <= 10^5
 0 <= a_i <= 10^5

 Output Format

 After each new integer is added to the list, print the list's updated median on
 a new line as a single double-precision number scaled to 1 decimal place (i.e., 12.3 format).

 Sample Input

 6
 12
 4
 5
 3
 8
 7

 Sample Output

 12.0
 8.0
 5.0
 4.5
 5.0
 6.0

 * Created by karataev on 7/15/16.
 */
public class HeapRunningMedian {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);

        int ops = in.nextInt();

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(ops, Collections.reverseOrder());

        int first = in.nextInt();
        System.out.println((double) first);
        int second = in.nextInt();
        System.out.println((first + second) / 2.0);

        if (first < second) {
            max.add(first);
            min.add(second);
        } else {
            max.add(second);
            min.add(first);
        }

        for (int i = 0; i < ops - 2; i++) {
            int next = in.nextInt();
            if (next < max.peek()) {
                max.add(next);
            } else {
                min.add(next);
            }

            if (min.size() - max.size() > 1) {
                max.add(min.poll());
            } else if (max.size() - min.size() > 1) {
                min.add(max.poll());
            }

            if (max.size() == min.size()) {
                System.out.println((double) (max.peek() + min.peek()) / 2.0);
            } else {
                double mid = max.size() > min.size() ? max.peek() : min.peek();
                System.out.println(mid);
            }
        }

        in.close();
    }
}
