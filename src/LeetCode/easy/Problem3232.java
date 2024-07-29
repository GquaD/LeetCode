package LeetCode.easy;

public class Problem3232 {
    //https://leetcode.com/problems/find-if-digit-game-can-be-won/description/

    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.66
    //MB
    //Beats
    //100.00%
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int n: nums) {
            if (n > 9) sum2 += n;
            else sum1 += n;
        }
        return sum1 != sum2;
    }
}
