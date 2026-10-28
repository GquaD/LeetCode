package LeetCode.medium;

public class Problem4084 {
    //10min
    //Runtime
    //11
    //ms
    //Beats
    //46.42%
    //Memory
    //173.56
    //MB
    //Beats
    //92.33%
    public int[] lastVisitedCell(char[][] grid) {
        int r = 0, c = 0, rows = grid.length, cols = grid[0].length;

        while (true) {
            char cur = grid[r][c];
            grid[r][c] = 'X';
            if (cur == 'U' && moveValid(r - 1, c, grid, rows, cols)) {
                r--;
            } else if (cur == 'R' && moveValid(r, c + 1, grid, rows, cols)) {
                c++;
            } else if (cur == 'D' && moveValid(r + 1, c, grid, rows, cols)) {
                r++;
            } else if (cur == 'L' && moveValid(r, c - 1, grid, rows, cols)) {
                c--;
            } else break;
        }

        return new int[]{r, c};
    }

    private boolean moveValid(int r, int c, char[][] grid, int rows, int cols) {
        return cellExists(r, c, rows, cols) && isValidValue(r, c, grid);
    }

    private boolean cellExists(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }

    private boolean isValidValue(int r, int c, char[][] grid) {
        char cur = grid[r][c];
        return cur == 'U' || cur == 'R' || cur == 'D' || cur == 'L';
    }
}
