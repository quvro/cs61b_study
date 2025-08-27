import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    WeightedQuickUnionUF ufBoard;
    Block[][] board;
    int openSites;

    private class Block {
        int x, y;
        boolean isOpen;
        boolean isFull;

        public Block(int col, int row){
            x = col;
            y = row;
            isOpen = false;
            isFull = false;
        }
    }

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        ufBoard = new WeightedQuickUnionUF(N * N);
        board = new Block[N][N];
        openSites = 0;
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
        Block cur = board[row][col];
        if (!cur.isOpen) {
            cur.isOpen = true;
            openSites ++;
        }
    }

    public boolean isOpen(int row, int col) {
        return board[row][col].isOpen;
    }

    public boolean isFull(int row, int col) {
        return board[row][col].isFull;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return false;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).

}
