package Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Algorithms Princeton.
 * Percolation exercise.
 * @author karataev
 *
 */
public class Percolation {
	
	boolean isPercolate;
	boolean[][] percolationGrid;
	int length;
	WeightedQuickUnionUF quickUnionObject;
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int N) {
		length = N;
		
		// boolean array for efficiency
		percolationGrid = new boolean[N][N];
		
		// TODO: Map 2D grid to 1D data structure
		//weUf = new WeightedQuickUnionUF(N * N + 2);
		quickUnionObject = new WeightedQuickUnionUF(N * N + 2);
		
		// Add top center
		for (int i = 0; i < N; i++) {
			quickUnionObject.union(0, i);
		}
		
	}
	
	// open site (row i, column j) if it is not open already
	public void open(int i, int j) {
		
		if (!isOpen(i, j)) {
			percolationGrid[i - 1][j - 1] = true;
			connectBlocks(i, j);
		}
	}
	
	// is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
    	//System.out.println("Coordinates: " + i + " " + j);
    	if (i < 1 || j < 1 || i > length || j > length) {
    		return false;
    	}
    	
    	return percolationGrid[i - 1][j - 1] == true;
    }
    
    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
    	//System.out.println("Coordinates: " + i + " " + j);
    	
    	if (isOpen(i, j) && quickUnionObject.connected(0, getIndex(i, j))) {
    		
    		if (i == length) {
    			isPercolate = true;
    		}
    		
    		return true;
    	} else {
        	return false;
    	}
    	
    }
    
    // does the system percolate?
    public boolean percolates() {
    	return isPercolate;
    }
    
    // test client (optional)
    public static void main(String[] args) {
    	
    }
    
    /**
     * Map Matrix 2D coordinates to array 1D coordinates
     * @param i column index
     * @param j row index
     * @return matrix 2D index converted to array index
     */
    private int getIndex(int i, int j) {
    	
    	return (i - 1) * length + j - 1;
    	
    }
    
    /**
     * Connect all vertically and horizontally adjacent blocks with the called block 
     * @param i column of the block
     * @param j row of the block
     */
    private void connectBlocks(int i, int j) {
    	
    	if (i > 0 && j > 0 && i <= length && j <= length) {
        		
       		if (isOpen(i, j - 1) && j > 1) {
           		quickUnionObject.union(getIndex(i, j), getIndex(i, j - 1));
        	}
        	if (isOpen(i, j + 1) && j < length) {
           		quickUnionObject.union(getIndex(i, j), getIndex(i, j + 1));
       		}
       		if (isOpen(i - 1, j) && i > 1) {
           		quickUnionObject.union(getIndex(i, j), getIndex(i - 1, j));
       		}
       		if (isOpen(i + 1, j) && i < length) {
           		quickUnionObject.union(getIndex(i, j), getIndex(i + 1, j));
       		}
        }
    }
	
}
