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

import java.util.ArrayList;

/**
 * Pascal Triangle Algorithm
 * Created by karataev on 7/24/16.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        genTriangle(2);
    }

    private static void genTriangle(int rows) {

        if (rows < 0) {
            return;
        }

        // save the last row here
        ArrayList<Integer> last = new ArrayList<>();
        last.add(1);
        System.out.println(last);

        for (int i = 1; i <= rows; i++) {
            // work on the next row
            ArrayList<Integer> thisRow = new ArrayList<>();
            thisRow.add(last.get(0)); // beginning

            for (int j = 1; j < i; j++) { // loop the number of elements in this row
                // sum from the last row
                thisRow.add(last.get(j - 1) + last.get(j));
            }

            thisRow.add(last.get(0)); // end
            last = thisRow; // save this row
            System.out.println(thisRow);
        }
    }

}
