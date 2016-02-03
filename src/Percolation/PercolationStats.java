package Percolation;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	   
	private double[] percolations;
	//private int[] moves;
	private int experiments;
	private int gridSize;
	
	// perform T independent experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		
		gridSize = N;
		int[] moves = new int[N * N];
		
		for (int i = 0; i < N * N; i++) {
			moves[i] = i;
		}
		
		
		percolations = new double[T];
		experiments = T;
		
		for (int i = 0; i < T; i++) {
			StdRandom.shuffle(moves);
			Percolation perc = new Percolation(N);
			int turn = 0;
			
			while (!perc.percolates() && turn < N * N) {

				int row = moves[turn] / N + 1;
				int column = moves[turn] % N;
				if (column == 0) column = N;
				//System.out.println("coords: " + row + " " + column + " turn: " + turn);

				perc.open(row, column);
				perc.isFull(row, column);
				turn++;
				
			}
			//System.out.println("turn " + turn);
			percolations[i] = (double) turn / (N * N); 
			
		}
	}
	
	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(percolations);
	}
	
	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(percolations);
	}
	
	// low  endpoint of 95% confidence interval
	public double confidenceLo() {
		return mean() - (1.96 * stddev()) / Math.sqrt(experiments);
	}
	
	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return mean() + (1.96 * stddev()) / Math.sqrt(experiments);
	}

	// test client (described below)
	public static void main(String[] args) {
		
		if (args.length < 2 || Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
    		throw new IllegalArgumentException("check arguments, N <= 0, T <= 0");
		}
		
		// arguments on launch
		int gridSize = Integer.parseInt(args[0]);
		int experiments = Integer.parseInt(args[1]);
				
		PercolationStats percolationStats = new PercolationStats(gridSize, experiments);
		
		System.out.print("mean = " + percolationStats.mean() + "\n" 
				+ "stddev = " + percolationStats.stddev() + "\n" 
				+ "95% confidence interval = " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
		
	}
	
	
}
	