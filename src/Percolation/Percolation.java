package Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Algorithms Princeton.
 * Percolation exercise.
 * @author karataev
 *
 */
public class Percolation {
	
	int[][] percolationGrid;
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int N) {
		
		// initialize each element of the percolation grid to 0
		percolationGrid = new int[N][N];
		for (int i = 0, n = percolationGrid.length; i < n; i++) {
			for (int j = 0, jn = percolationGrid.length; j < n; j++) {
				percolationGrid[i][j] = 0;
			}
		}
		
		
		// TODO: Map 2D grid to 1D data structure
		WeightedQuickUnionUF weUf = new WeightedQuickUnionUF(N * N);
		
		// TODO: 
	}
	
	// open site (row i, column j) if it is not open already
	public void open(int i, int j) {
		percolationGrid[i - 1][j - 1] = 1;
	}
	
	// is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
    	
    	if (percolationGrid[i - 1][j - 1] == 1) {
    		return true;
    	} else {
        	return false;
    	}
    }
    
    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
    	
    	if (percolationGrid[i - 1][j - 1] == 0) {
    		return true;
    	} else {
        	return false;
    	}
    	
    }
    
    // does the system percolate?
    public boolean percolates() {
    	
    	return false;
    }
    
    // test client (optional)
    public static void main(String[] args) {
    	
    }
	
}
