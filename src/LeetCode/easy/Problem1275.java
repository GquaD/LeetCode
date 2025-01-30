package LeetCode.easy;

public class Problem1275 {
    //https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/solutions/6348304/java-elegant-100-faster-solution-by-tbek-6v7q/
    //10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.26
    //MB
    //Beats
    //65.91%
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0], col = moves[i][1];
            if (i % 2 == 0) {
                board[row][col] = 1;
            } else {
                board[row][col] = 2;
            }
            String winner = findWinner(board);
            if (winner.length() > 0) return winner;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private String findWinner(int[][] board) {
        for (int i = 0; i < 3; i++) {
            int ones = 0, twos = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 1) {
                    ones++;
                } else if (board[i][j] == 2) {
                    twos++;
                }
            }
            if (ones == 3) return "A";
            else if (twos == 3) return "B";

            ones = 0;
            twos = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 1) {
                    ones++;
                } else if (board[j][i] == 2) {
                    twos++;
                }
            }
            if (ones == 3) return "A";
            else if (twos == 3) return "B";
        }

        if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1
                || board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
            return "A";
        } else if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2
                || board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
            return "B";
        }

        return "";
    }
}
