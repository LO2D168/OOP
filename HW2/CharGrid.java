package OOP.HW2;

public class CharGrid {
    private final char[][] g;
    private final int R, C;

    public CharGrid(char[][] grid) {
        this.g = grid;
        this.R = grid.length;
        this.C = (R == 0 ? 0 : grid[0].length);
    }

    public int charArea(char ch) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        int maxR = -1, maxC = -1;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (g[r][c] == ch) {
                    if (r < minR) minR = r;
                    if (c < minC) minC = c;
                    if (r > maxR) maxR = r;
                    if (c > maxC) maxC = c;
                }
            }
        }
        if (maxR == -1) return 0;
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    public int countPlus() {
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (isPlusCenter(r, c)) count++;
            }
        }
        return count;
    }

    private boolean in(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    private int armLenInclCenter(int r, int c, int dr, int dc) {
        char ch = g[r][c];
        int len = 0;
        int rr = r, cc = c;
        while (in(rr, cc) && g[rr][cc] == ch) {
            len++;
            rr += dr; cc += dc;
        }
        return len;
    }

    private boolean isPlusCenter(int r, int c) {
        int up    = armLenInclCenter(r, c, -1, 0);
        int down  = armLenInclCenter(r, c,  1, 0);
        int left  = armLenInclCenter(r, c,  0,-1);
        int right = armLenInclCenter(r, c,  0, 1);
        if (up < 2 || down < 2 || left < 2 || right < 2) return false;
        return up == down && left == right && up == left;
    }
}
