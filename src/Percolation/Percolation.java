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
	int length;
	WeightedQuickUnionUF weUf;
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int N) {
		length = N;
		
		// initialize each element of the percolation grid to 0
		percolationGrid = new int[N][N];
		for (int i = 0, n = percolationGrid.length; i < n; i++) {
			for (int j = 0, jn = percolationGrid.length; j < n; j++) {
				percolationGrid[i][j] = 0;
			}
		}
		
		// TODO: Map 2D grid to 1D data structure
		weUf = new WeightedQuickUnionUF(N * N + 2);
		
		// Add top and bottom centers
		for (int i = 0; i < N; i++) {
			weUf.union(0, i);
			weUf.union(N * N - N + i, N * N + 1);
		}
		
		// TODO: 
	}
	
	// open site (row i, column j) if it is not open already
	public void open(int i, int j) {
		
		if (!isOpen(i, j)) {
			percolationGrid[i - 1][j - 1] = 1;
			connectBlocks(i, j);
		}
	}
	
	// is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
    	//System.out.println("Coordinates: " + i + " " + j);
    	if (i < 1 || j < 1 || i > length || j > length) {
    		return false;
    	}
    	
    	if (percolationGrid[i - 1][j - 1] == 1) {
    		return true;
    	} else {
        	return false;
    	}
    }
    
    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
    	//System.out.println("Coordintaes: " + i + " " + j);
    	
    	if (isOpen(i, j) && weUf.connected(0, getIndex(i, j))) {
    		return true;
    	} else {
        	return false;
    	}
    	
    }
    
    // does the system percolate?
    public boolean percolates() {
    	if (weUf.connected(0, length * length + 1)) {
    		return true;
    	} else {
        	return false;
    	}
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
        		weUf.union(getIndex(i, j), getIndex(i, j - 1));
    		}
    		if (isOpen(i, j + 1) && j < length) {
        		weUf.union(getIndex(i, j), getIndex(i, j + 1));
    		}
    		if (isOpen(i - 1, j) && i > 1) {
        		weUf.union(getIndex(i, j), getIndex(i - 1, j));
    		}
    		if (isOpen(i + 1, j) && i < length) {
        		weUf.union(getIndex(i, j), getIndex(i + 1, j));
    		}
    		
    	}
    	
    }
	
}
