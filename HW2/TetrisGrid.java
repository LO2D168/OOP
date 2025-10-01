package OOP.HW2;

public class TetrisGrid {
    private final int W, H;
    private final boolean[][] grid;

    public TetrisGrid(boolean[][] src) {
        this.W = src.length;
        this.H = src[0].length;
        this.grid = new boolean[W][H];
        for (int x = 0; x < W; x++) {
            System.arraycopy(src[x], 0, this.grid[x], 0, H);
        }
    }

    public void clearRows() {
        int writeY = 0;
        for (int y = 0; y < H; y++) {
            if (!isRowFull(y)) {
                if (writeY != y) {
                    for (int x = 0; x < W; x++) grid[x][writeY] = grid[x][y];
                }
                writeY++;
            }
        }
        for (int y = writeY; y < H; y++) {
            for (int x = 0; x < W; x++) grid[x][y] = false;
        }
    }

    private boolean isRowFull(int y) {
        for (int x = 0; x < W; x++) if (!grid[x][y]) return false;
        return true;
    }

    public boolean[][] getGrid() {
        return grid;
    }
}
