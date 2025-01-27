package LeetCode.easy;

public class Problem3423 {
    //https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/solutions/6335447/java-on-solution-by-tbekpro-z7eh/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //99.82%
    //Analyze Complexity
    //Memory
    //43.97
    //MB
    //Beats
    //10.60%
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, Math.abs(nums[i - 1] - nums[i % nums.length]));
        }
        return max;
    }
}
