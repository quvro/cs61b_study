import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private WeightedQuickUnionUF ufBoard;
    private Block[][] board;
    private int openSites;
    private static int size;

    private class Block {
        boolean isOpen;
        boolean isFull;

        public Block(){
            isOpen = false;
            isFull = false;
        }
    }

    public Percolation(int N) {
        ufBoard = new WeightedQuickUnionUF(N * N);
        board = new Block[N][N];
        openSites = 0;
        size = N;

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                board[i][j] = new Block();
            }
        }
    }

    public void open(int row, int col) {
        Block cur = board[row][col];
        if (!cur.isOpen) {
            cur.isOpen = true;
            openSites ++;
            connect(row, col);
            full();
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
        for (int i = 0; i < size; i ++) {
            for (int j = size * size - 1; j >= size * size - size; j --) {
                if (ufBoard.connected(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).

    // Turn row and col into ufboard number.
    private int xyToNo(int row, int col) {
        return row * size + col;
    }

    private Block noToXy(int no) {
        int row = no / size;
        int col = no - row * size;
        return board[row][col];
    }

    private void connect(int row, int col) {
        // connect up, down, left and right
        if (row - 1 >= 0 && board[row - 1][col].isOpen) ufBoard.union(xyToNo(row, col), xyToNo(row - 1, col));
        if (row + 1 < size && board[row + 1][col].isOpen) ufBoard.union(xyToNo(row, col), xyToNo(row + 1, col));
        if (col - 1 >= 0 && board[row][col - 1].isOpen) ufBoard.union(xyToNo(row, col), xyToNo(row, col - 1));
        if (col + 1 < size && board[row][col + 1].isOpen) ufBoard.union(xyToNo(row, col), xyToNo(row, col + 1));
    }

    private void full() {
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size * size; j ++) {
                if (noToXy(j).isOpen && ufBoard.connected(i, j)) noToXy(j).isFull = true;
            }
        }
    }

}
