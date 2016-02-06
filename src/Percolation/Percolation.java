package Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Algorithms Princeton.
 * Percolation exercise.
 *
 * @author karataev
 */
public class Percolation {

    private boolean[] percolationGrid;
    private final int length;
    private WeightedQuickUnionUF quickUnionObject, quickUnionObjectSecond;


    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("illegal argument " + N);
        }
        length = N;

        // boolean array for efficiency
        percolationGrid = new boolean[N * N];

        // UnionFindObject
        quickUnionObject = new WeightedQuickUnionUF(N * N + 2);
        quickUnionObjectSecond = new WeightedQuickUnionUF(N * N + 2);

        // Add top center
        for (int i = 1; i <= N; i++) {
            quickUnionObject.union(0, i);
            quickUnionObjectSecond.union(0, i);
            quickUnionObjectSecond.union(N * N + 1, N * N - i + 1);
        }

    }

    // test client (optional)
    public static void main(String[] args) {

    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {

        if (!isOpen(i, j)) {
            percolationGrid[get1dIndex(i, j)] = true;
            connectBlocks(i, j);
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i < 1 || j < 1 || i > length || j > length) {
            throw new IndexOutOfBoundsException("row index i out of bounds: " + i + " " + j);
        }

        return percolationGrid[get1dIndex(i, j)];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i < 1 || j < 1 || i > length || j > length) {
            throw new IndexOutOfBoundsException("row index i out of bounds: " + i + " " + j);
        }

        return isOpen(i, j) && quickUnionObject.connected(0, getIndex(i, j));

    }

    // does the system percolate?
    public boolean percolates() {
        if (length == 1) {
            return percolationGrid[0];
        } else {
            return quickUnionObjectSecond.connected(0, length * length + 1);
        }
    }

    /**
     * Map Matrix 2D coordinates to array 1D coordinates
     *
     * @param i column index
     * @param j row index
     * @return matrix 2D index converted to array index
     */
    private int getIndex(int i, int j) {
        return i * length - (length - j);
    }

    /**
     * Connect all vertically and horizontally adjacent blocks with the called block
     *
     * @param i column of the block
     * @param j row of the block
     */
    private void connectBlocks(int i, int j) {

        if (i > 0 && j > 0 && i <= length && j <= length) {

            if (j > 1 && isOpen(i, j - 1)) {
                quickUnionObject.union(getIndex(i, j), getIndex(i, j - 1));
                quickUnionObjectSecond.union(getIndex(i, j), getIndex(i, j - 1));

            }
            if (j < length && isOpen(i, j + 1)) {
                quickUnionObject.union(getIndex(i, j), getIndex(i, j + 1));
                quickUnionObjectSecond.union(getIndex(i, j), getIndex(i, j + 1));

            }
            if (i > 1 && isOpen(i - 1, j)) {
                quickUnionObject.union(getIndex(i, j), getIndex(i - 1, j));
                quickUnionObjectSecond.union(getIndex(i, j), getIndex(i - 1, j));

            }
            if (i < length && isOpen(i + 1, j)) {
                quickUnionObject.union(getIndex(i, j), getIndex(i + 1, j));
                quickUnionObjectSecond.union(getIndex(i, j), getIndex(i + 1, j));
            }
        } else {
            throw new IndexOutOfBoundsException("row index i out of bounds");
        }
    }

    /**
     * Method to map 2D coordinates to 1D array
     * @param i row
     * @param j column
     * @return 1D coordinate
     */
    private int get1dIndex(int i, int j) {
        return (i * length - (length - j)) - 1;
    }

}
