package LeetCode.easy;

public class Problem3238 {
    //https://leetcode.com/problems/find-the-number-of-winning-players/description/


    //https://leetcode.com/problems/find-the-number-of-winning-players/solutions/5660159/java-ono1-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.60
    //MB
    //Beats
    //99.06%
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] arr = new int[11][11];
        for (int i = 0; i < pick.length; i++) {
            int player = pick[i][0], color = pick[i][1];
            arr[player][color]++;
        }
        int winners = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] > i) {
                    winners++;
                    break;
                }
            }
        }
        return winners;
    }
}
