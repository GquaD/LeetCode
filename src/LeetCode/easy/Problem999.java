package LeetCode.easy;

public class Problem999 {
    //https://leetcode.com/problems/available-captures-for-rook/
    public static void main(String[] args) {
        System.out.println(numRookCaptures(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        System.out.println(numRookCaptures(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        System.out.println(numRookCaptures(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Available Captures for Rook.
    //Memory Usage: 42.2 MB, less than 6.15% of Java online submissions for Available Captures for Rook.

    static int numRookCaptures(char[][] board) {
        int[] rowCol = findRook(board);
        int countCaptures = 0;
        if (canCaptureUp(rowCol, board)) countCaptures++;
        if (canCaptureRight(rowCol, board)) countCaptures++;
        if (canCaptureDown(rowCol, board)) countCaptures++;
        if (canCaptureLeft(rowCol, board)) countCaptures++;
        return countCaptures;
    }

    private static int[] findRook(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    private static boolean canCaptureUp(int[] rowCol, char[][] board) {
        int row = rowCol[0];
        int col = rowCol[1];
        while (cellExist(--row, col, board)) {
            char cell = board[row][col];
            if (cell == 'p') {
                return true;
            } else if (cell == 'B') {
                return false;
            }
        }
        return false;
    }

    private static boolean canCaptureRight(int[] rowCol, char[][] board) {
        int row = rowCol[0];
        int col = rowCol[1];
        while (cellExist(row, ++col, board)) {
            char cell = board[row][col];
            if (cell == 'p') {
                return true;
            } else if (cell == 'B') {
                return false;
            }
        }
        return false;
    }

    private static boolean canCaptureDown(int[] rowCol, char[][] board) {
        int row = rowCol[0];
        int col = rowCol[1];
        while (cellExist(++row, col, board)) {
            char cell = board[row][col];
            if (cell == 'p') {
                return true;
            } else if (cell == 'B') {
                return false;
            }
        }
        return false;
    }

    private static boolean canCaptureLeft(int[] rowCol, char[][] board) {
        int row = rowCol[0];
        int col = rowCol[1];
        while (cellExist(row, --col, board)) {
            char cell = board[row][col];
            if (cell == 'p') {
                return true;
            } else if (cell == 'B') {
                return false;
            }
        }
        return false;
    }

    private static boolean cellExist(int row, int col, char[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }
}
