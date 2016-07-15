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
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

 Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {)
 occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 There are three types of matched pairs of brackets: [], {}, and ().

 A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 The pair of square brackets encloses a single, unbalanced opening bracket, (,
 and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

 By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

 It contains no unmatched brackets.
 The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 Given n strings of brackets, determine whether each sequence of brackets is balanced.
 If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

 Input Format

 The first line contains a single integer, n, denoting the number of strings.
 Each line i of the n subsequent lines consists of a single string, s, denoting a sequence of brackets.

 Constraints
 1 <= n <= 10^3
 1 <= len_s <= 10^3, where len_s is the length of the sequence.
 Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).

 Output Format

 For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.

 Sample Input

 3
 {[()]}
 {[(])}
 {{[[(())]]}}
 Sample Output

 YES
 NO
 YES
 Explanation

 The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced.
 The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.

 * Created by karataev on 7/14/16.
 */
public class BalancedParent {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();


        for (int a0 = 0; a0 < t; a0++) {

            String s = in.nextLine();

            System.out.println(isBalanced(s));

        }

        in.close();
    }

    public static String isBalanced(String s) {

        Map<Character, Character> map = new HashMap<>(3);
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.size() > 0 && map.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                return "NO";
            }
        }

        if (stack.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
