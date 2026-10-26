package LeetCode.medium;

public class Problem200 {
    //15min
    //Runtime
    //3
    //ms
    //Beats
    //88.00%
    //Memory
    //51.88
    //MB
    //Beats
    //72.70%
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    result++; //visited
                    traverse(r, c, rows, cols, grid);
                }
            }
        }

        return result;
    }

    private void traverse(int r, int c, int rows, int cols, char[][] grid) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;

        if (grid[r][c] == '1') {
            grid[r][c] = '0';
            traverse(r - 1, c, rows, cols, grid);
            traverse(r, c + 1, rows, cols, grid);
            traverse(r + 1, c, rows, cols, grid);
            traverse(r, c - 1, rows, cols, grid);
        }
    }
}
