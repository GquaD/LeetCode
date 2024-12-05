package LeetCode.easy;

public class Problem1176 {
    //https://leetcode.com/problems/diet-plan-performance
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/diet-plan-performance/solutions/6116043/java-o-n-sliding-window-solution/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //98.73%
    //Analyze Complexity
    //Memory
    //48.53
    //MB
    //Beats
    //84.74%
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        points = sum < lower ? points - 1 : sum > upper ? points + 1 : points;
        for (int i = k; i < calories.length; i++) {
            sum -= calories[i - k];
            sum += calories[i];
            points = sum < lower ? points - 1 : sum > upper ? points + 1 : points;
        }
        return points;
    }
}
