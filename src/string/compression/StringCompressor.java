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

package string.compression;

import java.util.Scanner;

/**
 * Class to compress strings, by calculating repetitive letters and convert them to indices
 */
public class StringCompressor {

    /**
     * Creates a compressed String by calculating consecutive letters
     * @param input initial String
     * @return compressed String if it is smaller, than the input.
     */
    public static String compress(String input) {

        // Usually words don't have many the same consecutive letters,
        // that's why we chack if it makes sense to compress the word
        int maxLength = maxLength(input);
        if (input.length() <= maxLength) {
            return input;
        }

        int index = 1;

        // at this point we know the exact length of the compressed word
        StringBuilder stringBuilder = new StringBuilder(maxLength);

        for (int i = 0, n = input.length(); i < n - 1; i++) {

            if (input.charAt(i) == input.charAt(i + 1)) {
                index++;
            } else {
                stringBuilder.append(input.charAt(i));
                stringBuilder.append(index);
                index = 1;
            }
        }

        // To catch the last letter
        stringBuilder.append(input.charAt(input.length() - 1));
        stringBuilder.append(index);

        return stringBuilder.toString();

    }

    /**
     * Precalculate possible max length of the input when compressed
     * @param input to compress
     * @return length of the compressed word
     */
    public static int maxLength(String input) {
        if (input.length() == 1) {
            return 2;
        }

        int maxLength = 2;

        for (int i = 0, n = input.length(); i < n - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                maxLength += 2;
            }
        }

        return maxLength;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();

        System.out.println("input: " + a + ", compressed: " + compress(a));
    }



}
