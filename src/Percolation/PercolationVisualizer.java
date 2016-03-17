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

package Percolation;

/******************************************************************************
 * Compilation:  javac PercolationVisualizer.java
 * Execution:    java PercolationVisualizer input.txt
 * Dependencies: Percolation.java
 * <p>
 * This program takes the name of a file as a command-line argument.
 * From that file, it
 * <p>
 * - Reads the grid size N of the percolation system.
 * - Creates an N-by-N grid of sites (intially all blocked)
 * - Reads in a sequence of sites (row i, column j) to open.
 * <p>
 * After each site is opened, it draws full sites in light blue,
 * open sites (that aren't full) in white, and blocked sites in black,
 * with with site (1, 1) in the upper left-hand corner.
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class PercolationVisualizer {

    // delay in miliseconds (controls animation speed)
    private static final int DELAY = 100;

    // draw N-by-N percolation system
    public static void draw(Percolation perc, int N) {

        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-.05 * N, 1.05 * N);
        StdDraw.setYscale(-.05 * N, 1.05 * N);   // leave a border to write text
        StdDraw.filledSquare(N / 2.0, N / 2.0, N / 2.0);

        // draw N-by-N grid
        int opened = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                } else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                } else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25 * N, -N * .025, opened + " open sites");
        if (perc.percolates()) {
            StdDraw.text(.75 * N, -N * .025, "percolates");
        } else {
            StdDraw.text(.75 * N, -N * .025, "does not percolate");
        }

    }

    public static void main(String[] args) {
        In in = new In("input6.txt");      // input file
        int N = in.readInt();         // N-by-N percolation system

        // turn on animation mode
        StdDraw.show(0);

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);
        draw(perc, N);
        StdDraw.show(DELAY);
        int iter = 1;
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            StdDraw.show(DELAY);
            System.out.println("move: " + iter + ", site: " + i + " " + j + ", isOpen " + perc.isOpen(i, j) + ", percolates: "
                    + perc.percolates() + ", isFull: " + perc.isFull(i, j) + " percolates boolean " + perc.isPercolates);
            iter++;
        }
        perc.checkEach();
    }
}
