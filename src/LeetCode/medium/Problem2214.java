package LeetCode.medium;

public class Problem2214 {
    //https://leetcode.com/problems/minimum-health-to-beat-game/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-health-to-beat-game/solutions/5911229/java-o-n-solution/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //94.51%
    //Analyze Complexity
    //Memory
    //57.92
    //MB
    //Beats
    //14.29%
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int max = 0;
        for (int n : damage) {
            sum += n;
            max = Math.max(max, n);
        }
        return  sum + 1 - Math.min(max, armor);
    }
}
