package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem79 {
    //https://leetcode.com/problems/word-search/
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCEFSADEESE"));
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));

    }

    //https://leetcode.com/problems/word-search/solutions/2917186/java-readable-solution/
    //50min - 1 hour
    //Runtime
    //192 ms
    //Beats
    //40.23%
    //Memory
    //40.2 MB
    //Beats
    //93.55%
    static boolean exists;
    static boolean exist(char[][] board, String word) {
        exists = false;
        List<Coordinates> list = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (word.charAt(0) == board[y][x]) {
                    list.add(new Coordinates(y, x));
                }
            }
        }
        for (Coordinates c : list) {
            visited[c.y][c.x] = true;
            checkIfExists(word, board, c.y, c.x, 0, visited);
            if (exists) return true;
            visited[c.y][c.x] = false;
        }
        return false;
    }

    private static void checkIfExists(String word, char[][] board, int y, int x, int idx, boolean[][] visited) {
        if (idx >= word.length() - 1) {
            exists = true;
            return;
        }
        idx++;
        char c = word.charAt(idx);
        //right
        if (cellExists(y, x + 1, board, visited) && board[y][x + 1] == c) {
            visited[y][x + 1] = true;
            checkIfExists(word, board, y, x + 1, idx, visited);
            visited[y][x + 1] = false;
        }
        //down
        if (cellExists(y + 1, x, board, visited) && board[y + 1][x] == c) {
            visited[y + 1][x] = true;
            checkIfExists(word, board, y + 1, x, idx, visited);
            visited[y + 1][x] = false;
        }
        //left
        if (cellExists(y, x - 1, board, visited) && board[y][x - 1] == c) {
            visited[y][x - 1] = true;
            checkIfExists(word, board, y, x - 1, idx, visited);
            visited[y][x - 1] = false;
        }
        //up
        if (cellExists(y - 1, x, board, visited) && board[y - 1][x] == c) {
            visited[y - 1][x] = true;
            checkIfExists(word, board, y - 1, x, idx, visited);
            visited[y - 1][x] = false;
        }
    }

    private static boolean cellExists(int row, int col, char[][] grid, boolean[][] visited) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col];
    }

    static class Coordinates {
        int y, x;

        public Coordinates(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
