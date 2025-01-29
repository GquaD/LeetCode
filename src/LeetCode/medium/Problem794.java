package LeetCode.medium;

public class Problem794 {
    //https://leetcode.com/problems/valid-tic-tac-toe-state/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/valid-tic-tac-toe-state/solutions/6343928/java-100-faster-solution-by-tbekpro-zztd/
    //15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.77
    //MB
    //Beats
    //92.18%
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        boolean winX = false, winO = false;

        //check number of xs and os
        for (String s : board) {
            for (int i = 0; i < 3; i++) {
                if (s.charAt(i) == 'X') x++;
                else if (s.charAt(i) == 'O') o++;
            }
        }
        if (o > x || x - o > 1) return false;
        int xxx = x, ooo = o;

        //check win
        //horizontal
        for (String s : board) {
            if (s.equals("XXX")) winX = true;
            else if (s.equals("OOO")) winO = true;
        }
        if (winX && winO) return false;
        //vertical
        for (int i = 0; i < 3; i++) {
            int xx = 0, oo = 0;
            for (int j = 0; j < 3; j++) {
                char c = board[j].charAt(i);
                if (c == 'X') xx++;
                else if (c == 'O') oo++;
            }
            if (xx == 3) winX = true;
            else if (oo == 3) winO = true;
        }
        if (winX && winO) return false;
        //diagonal
        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'
                || board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') {
            winX = true;
        }
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'
                || board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') {
            winO = true;
        }
        if (winX && winO) return false;
        if (winX && ooo >= xxx) return false;
        if (winO && ooo < xxx) return false;
        return true;
    }
}
