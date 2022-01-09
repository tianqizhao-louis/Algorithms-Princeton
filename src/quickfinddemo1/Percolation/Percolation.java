package src.quickfinddemo1.Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final boolean[][] sites;
    private int openedSites;
    private final int size;
    private final int top;
    private final int bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        // corner cases
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        // top: 0; bottom: size * size + 1
        uf = new WeightedQuickUnionUF(n * n + 2);

        this.sites = new boolean[n][n];
        this.openedSites = 0;
        this.size = n;
        this.top = 0;
        this.bottom = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        int[] formattedRowCol = convertRowCol(row, col);
        int fRow = formattedRowCol[0];
        int fCol = formattedRowCol[1];

        // if not open
        if (!isOpen(fRow+1, fCol+1)) {
            openedSites++;
            // 0 is not opened; 1 is opened
            this.sites[fRow][fCol] = true;

            if (fRow == 0) {
                // first row
                uf.union(toUFIndex(fRow, fCol), this.top);
            }

            if (fRow == this.size - 1) {
                // last row
                uf.union(toUFIndex(fRow, fCol), this.bottom);
            }

            // there exists a left column and it's open
            if (fCol > 0 && isOpen(fRow+1, fCol)) {
                uf.union(toUFIndex(fRow, fCol-1), toUFIndex(fRow, fCol));
            }

            // there exists a right column and it's open
            if (fCol < this.size-1 && isOpen(fRow+1, fCol+2)) {
                uf.union(toUFIndex(fRow, fCol+1), toUFIndex(fRow, fCol));
            }

            // there exists a top row and it's open
            if (fRow > 0 && isOpen(fRow, fCol+1)) {
                uf.union(toUFIndex(fRow-1, fCol), toUFIndex(fRow, fCol));
            }

            // there exists a bottom row and it's open
            if (fRow < this.size-1 && isOpen(fRow+2, fCol+1)) {
                uf.union(toUFIndex(fRow, fCol), toUFIndex(fRow+1, fCol));
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int[] formattedRowCol = convertRowCol(row, col);
        int fRow = formattedRowCol[0];
        int fCol = formattedRowCol[1];
        return this.sites[fRow][fCol];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int[] formattedRowCol = convertRowCol(row, col);
        int fRow = formattedRowCol[0];
        int fCol = formattedRowCol[1];
        if (!isOpen(fRow+1, fCol+1)) {
            return false;
        } else {
            // is a open site
            return uf.find(this.top) == uf.find(toUFIndex(fRow, fCol));
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(this.top) == uf.find(this.bottom);
    }


    private int toUFIndex(int fRow, int fCol) {
        return fRow * size + fCol + 1;
    }

    private int[] convertRowCol(int row, int col) {
        return new int[]{row - 1, col - 1};
    }

    private void validate(int row, int col) {
        if (row < 1 || row > this.size || col < 1 || col > this.size) {
            throw new IllegalArgumentException();
        }
    }
}
