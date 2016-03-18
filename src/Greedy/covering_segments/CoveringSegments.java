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

package Greedy.covering_segments;

import java.util.Scanner;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {

        int[] points = new int[segments.length];

        int left = -1;

        for (int i = 0, n = segments.length; i < n; i++) {
            int right = 999999999;

            for (Segment each : segments) {

                if (each.end <= right && each.start > left) {

                    right = each.end;
                    points[i] = right;
                    //System.out.println("left: " + left + ", right: " + right);
                }

            }
            //System.out.println("2 left: " + left + ", right: " + right);
            left = right;

        }

        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);

//        System.out.println(points.length);

        StringBuilder stringBuilder = new StringBuilder(points.length);
        int length = 0;
        for (int point : points) {
            if (point != 0) {
                length++;
                stringBuilder.append(point);
                stringBuilder.append(" ");
            }
        }
        System.out.println(length);
        System.out.println(stringBuilder.toString());
    }
}
 
