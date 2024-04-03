package LeetCode.medium;

public class Problem348 {
    //https://leetcode.com/problems/design-tic-tac-toe
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/design-tic-tac-toe/solutions/4967172/java-move-o-n-solution/
//10min
//Runtime
//13
//ms
//Beats
//6.12%
//of users with Java
//Memory
//45.90
//MB
//Beats
//8.52%
//of users with Java
class TicTacToe {
    int[][] arr;
    int m;
    public TicTacToe(int n) {
        arr = new int[n][n];
        m = n;
    }

    public int move(int row, int col, int player) {
        arr[row][col] = player;
        //column check
        int p1 = 0, p2 = 0;
        for (int r = 0; r < m; r++) {
            if (arr[r][col] == 1) p1++;
            if (arr[r][col] == 2) p2++;
        }
        if (p1 == m) return 1;
        if (p2 == m) return 2;

        //row check
        p1 = 0;
        p2 = 0;
        for (int c = 0; c < m; c++) {
            if (arr[row][c] == 1) p1++;
            if (arr[row][c] == 2) p2++;
        }
        if (p1 == m) return 1;
        if (p2 == m) return 2;

        //diag check from left down to top right
        p1 = 0;
        p2 = 0;
        int r = m - 1;
        for (int c = 0; c < m; c++) {
            if (arr[r][c] == 1) p1++;
            if (arr[r--][c] == 2) p2++;
        }

        if (p1 == m) return 1;
        if (p2 == m) return 2;

        //diag check from left top to bottom right
        p1 = 0;
        p2 = 0;
        r = 0;
        for (int c = 0; c < m; c++) {
            if (arr[r][c] == 1) p1++;
            if (arr[r++][c] == 2) p2++;
        }

        if (p1 == m) return 1;
        if (p2 == m) return 2;
        return 0;
    }
}
