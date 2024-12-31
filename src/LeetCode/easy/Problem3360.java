package LeetCode.easy;

public class Problem3360 {
    //https://leetcode.com/problems/stone-removal-game
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/stone-removal-game/solutions/6209753/java-100-faster-easy-solution-by-tbekpro-k4bx/
    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.54
    //MB
    //Beats
    //38.44%
    public boolean canAliceWin(int n) {
        int t = 10, count = 0;
        while (n >= t) {
            n -= t--;
            count++;
        }
        return count % 2 == 1;
    }
}
