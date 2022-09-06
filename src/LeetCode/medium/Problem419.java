package LeetCode.medium;

public class Problem419 {
    //https://leetcode.com/problems/battleships-in-a-board/
    public static void main(String[] args) {

    }

    //10-15 min
    //Runtime: 1 ms, faster than 92.11% of Java online submissions for Battleships in a Board.
    //Memory Usage: 44 MB, less than 74.25% of Java online submissions for Battleships in a Board.
    static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    count++;
                    goHorizontally(i, j, board, visited);
                    goVertically(i, j, board, visited);
                }
            }
        }
        return count;
    }

    private static void goHorizontally(int row, int col, char[][] board, boolean[][] visited) {
        while (cellExist(row, col, board) && board[row][col] == 'X') {
            visited[row][col] = true;
            col++;
        }
    }

    private static void goVertically(int row, int col, char[][] board, boolean[][] visited) {
        while (cellExist(row, col, board) && board[row][col] == 'X') {
            visited[row][col] = true;
            row++;
        }
    }

    private static boolean cellExist(int row, int col, char[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }
}
