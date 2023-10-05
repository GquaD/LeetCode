package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2018 {
    //https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/
    public static void main(String[] args) {
        System.out.println(placeWordInCrossword1(new char[][]{
                {'#',' ','#'},
                {'#',' ','#'},
                {'#',' ','c'}
        }, "ca"));

        System.out.println(placeWordInCrossword1(new char[][]{
                {'#', ' ', '#'},
                {' ', ' ', '#'},
                {'#', 'c', ' '}
        }, "abc"));

        System.out.println(placeWordInCrossword1(new char[][]{
                {' ', '#', 'a'},
                {' ', '#', 'c'},
                {' ', '#', 'a'}
        }, "ac"));

        System.out.println(placeWordInCrossword1(new char[][]{
                {'#', ' ', '#'},
                {' ', ' ', '#'},
                {'#', ' ', 'c'}
        }, "ac"));
    }


    //check github
    //https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/solutions/4133652/java-straightforward-solution/
    //50min
    //Runtime
    //20 ms
    //Beats
    //28.92%
    //Memory
    //70.7 MB
    //Beats
    //66.27%

    static boolean placeWordInCrossword1(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        List<int[]> listH = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            int len = 0;
            for (int c = 0; c < n; c++) {
                if (board[r][c] == ' ' || Character.isLowerCase(board[r][c])) {
                    len++;
                } else {
                    if (len == word.length()) listH.add(new int[]{r, c - len});
                    len = 0;
                }
            }
            if (len == word.length()) listH.add(new int[]{r, n - len});
        }

        for (int r = m - 1; r >= 0; r--) {
            int len = 0;
            for (int c = n - 1; c >= 0; c--) {
                if (board[r][c] == ' ' || Character.isLowerCase(board[r][c])) {
                    len++;
                } else {
                    if (len == word.length()) listH.add(new int[]{r, c + 1});
                    len = 0;
                }
            }
            if (len == word.length()) listH.add(new int[]{r, 0});
        }

        if (hasHorizontal(listH, board, word)) return true;

        List<int[]> listV = new ArrayList<>();
        for (int c = 0; c < n; c++) {
            int len = 0;
            for (int r = 0; r < m; r++) {
                if (board[r][c] == ' ' || Character.isLowerCase(board[r][c])) {
                    len++;
                } else {
                    if (len == word.length()) listV.add(new int[]{r - len, c});
                    len = 0;
                }
            }
            if (len == word.length()) listV.add(new int[]{m - len, c});
        }

        for (int c = n - 1; c >= 0; c--) {
            int len = 0;
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] == ' ' || Character.isLowerCase(board[r][c])) {
                    len++;
                } else {
                    if (len == word.length()) listV.add(new int[]{r + 1, c});
                    len = 0;
                }
            }
            if (len == word.length()) listV.add(new int[]{0, c});
        }

        if (hasVertical(listV, board, word)) return true;

        return false;
    }
    private static boolean hasHorizontal(List<int[]> listH, char[][] board, String word) {
        for (int[] arr : listH) {
            int count = 0, i = 0;
            for (int c = arr[1]; c < arr[1] + word.length(); c++) {
                if (board[arr[0]][c] == ' ' || board[arr[0]][c] == word.charAt(i)) count++;
                i++;
            }
            if (count == word.length()) return true;

            count = 0;
            i = 0;
            for (int c = arr[1] + word.length() - 1; c >= arr[1]; c--) {
                if (board[arr[0]][c] == ' ' || board[arr[0]][c] == word.charAt(i)) count++;
                i++;
            }
            if (count == word.length()) return true;
        }
        return false;
    }

    private static boolean hasVertical(List<int[]> listV, char[][] board, String word) {
        for (int[] arr : listV) {
            int count = 0, i = 0;
            for (int r = arr[0]; r < arr[0] + word.length(); r++) {
                if (board[r][arr[1]] == ' ' || board[r][arr[1]] == word.charAt(i)) count++;
                i++;
            }
            if (count == word.length()) return true;

            count = 0;
            i = 0;
            for (int r = arr[0] + word.length() - 1; r >= arr[0]; r--) {
                if (board[r][arr[1]] == ' ' || board[r][arr[1]] == word.charAt(i)) count++;
                i++;
            }
            if (count == word.length()) return true;
        }
        return false;
    }

    static boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        //left to right
        for (int r = 0; r < m; r++) {
            int len = 0;
            for (int c = 0; c < n; c++) {
                if (board[r][c] == ' ' || (len < word.length() && board[r][c] == word.charAt(len))) {
                    len++;
                } else {
                    if (len == word.length()) return true;
                    len = 0;
                }
            }
            if (len == word.length()) return true;
        }

        //up to down
        for (int c = 0; c < n; c++) {
            int len = 0;
            for (int r = 0; r < m; r++) {
                if (board[r][c] == ' ' || (len < word.length() && board[r][c] == word.charAt(len))) {
                    len++;
                } else {
                    if (len == word.length()) return true;
                    len = 0;
                }
            }
            if (len == word.length()) return true;
        }

        //right to left
        for (int r = m - 1; r >= 0; r--) {
            int len = 0;
            for (int c = n - 1; c >= 0; c--) {
                if (board[r][c] == ' ' || (len < word.length() && board[r][c] == word.charAt(len))) {
                    len++;
                } else {
                    if (len == word.length()) return true;
                    len = 0;
                }
            }
            if (len == word.length()) return true;
        }

        //down to up
        for (int c = n - 1; c >= 0; c--) {
            int len = 0;
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] == ' ' || (len < word.length() && board[r][c] == word.charAt(len))) {
                    len++;
                } else {
                    if (len == word.length()) return true;
                    len = 0;
                }
            }
            if (len == word.length()) return true;
        }
        return false;
    }
}
