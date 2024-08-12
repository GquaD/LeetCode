package LeetCode.easy;

public class Problem3222 {
    //https://leetcode.com/problems/find-the-winning-player-in-coin-game


    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.52
    //MB
    //Beats
    //63.43%
    public String losingPlayer(int x, int y) {
            int count = 0;
            while (x >= 1 && y >= 4) {
                x--;
                y-= 4;
                count++;
            }
            return count % 2 == 1 ? "Alice" : "Bob";
        }
}
