package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem36 {
    //https://leetcode.com/problems/valid-sudoku/

    public static void main(String[] args) {

    }

    //5-10 more minutes
    //https://leetcode.com/problems/valid-sudoku/solutions/2701434/java-98-faster-o-n-only-arrays-used/
    //Runtime
    //2 ms
    //Beats
    //97.48%
    //Memory
    //46.3 MB
    //Beats
    //66.45%
    static boolean isValidSudoku(char[][] board) {
        byte[] arr = new byte[10];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (arr[c - '0'] > 0) {
                    return false;
                } else {
                    arr[c - '0']++;
                }
            }
            clearArray(arr);
        }
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (arr[c - '0'] > 0) {
                    return false;
                } else {
                    arr[c - '0']++;
                }
            }
            clearArray(arr);
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char ch = board[row + r][col + c];
                        if (ch == '.') continue;
                        if (arr[ch - '0'] > 0) {
                            return false;
                        } else {
                            arr[ch - '0']++;
                        }
                    }
                }
                clearArray(arr);
            }
        }
        return true;
    }

    private static void clearArray(byte[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    //https://leetcode.com/problems/valid-sudoku/solutions/2701386/java-straightforward-solution-o-n/
    //15 minutes
    //Runtime
    //7 ms
    //Beats
    //57.93%
    //Memory
    //46.1 MB
    //Beats
    //68.19%
    static boolean isValidSudoku1(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
            set.clear();
        }
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
            set.clear();
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char ch = board[row + r][col + c];
                        if (ch == '.') continue;
                        if (set.contains(ch)) {
                            return false;
                        } else {
                            set.add(ch);
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
