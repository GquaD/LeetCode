package LeetCode.hard;

public class Problem2267 {
    //1h

    //Runtime
    //4
    //ms
    //Beats
    //97.14%
    //Memory
    //48.83
    //MB
    //Beats
    //87.62%
    public boolean hasValidPath(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        if ((rows + cols) % 2 == 0)
            return false;

        boolean[][][] visited = new boolean[rows][cols][rows + cols];

        return traverse(0, 0, rows, cols, grid, 0, visited);
    }

    private boolean traverse(int r, int c, int rows, int cols, char[][] grid, int open, boolean[][][] visited) {
        char ch = grid[r][c];

        if (ch == '(') {
            open++;
        } else if (open <= 0) {
            return false;
        } else {
            open--;
        }

        if (r >= rows - 1 && c >= cols - 1) {
            return open == 0;
        }

        if (visited[r][c][open]) return false;
        visited[r][c][open] = true;

        if (cellExists(r, c + 1, rows, cols)) {
            if (traverse(r, c + 1, rows, cols, grid, open, visited))
                return true;
        }

        if (cellExists(r + 1, c, rows, cols)) {
            if (traverse(r + 1, c, rows, cols, grid, open, visited))
                return true;
        }

        return false;
    }

    private boolean cellExists(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}
