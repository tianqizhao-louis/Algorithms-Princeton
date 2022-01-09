package src.quickfinddemo1.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] results;
    private final int totalTrials;
    private final int size;
    private final static double calcConstant = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        this.results = new double[trials];
        this.totalTrials = trials;
        this.size = n;

        runExperiments();
    }

    private void runExperiments() {
        for (int i = 0; i < this.totalTrials; i++) {
            Percolation p = new Percolation(this.size);
            while (!p.percolates()) {
                int row = StdRandom.uniform(1, this.size+1);
                int col = StdRandom.uniform(1, this.size+1);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            this.results[i] = (double) p.numberOfOpenSites() / (double) (this.size * this.size);
        }
    }


    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((calcConstant * stddev()) / Math.sqrt(totalTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((calcConstant * stddev()) / Math.sqrt(totalTrials));
    }

   // test client (see below)
   public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("mean = " + ps.mean());
        System.out.println("stddev = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi());
   }
}
