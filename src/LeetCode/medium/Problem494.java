package LeetCode.medium;

public class Problem494 {
    //https://leetcode.com/problems/target-sum/
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    //https://leetcode.com/problems/target-sum/solutions/4178312/java-backtracking-solution/
    //5min
    //Runtime
    //548 ms
    //Beats
    //6.1%
    //Memory
    //40.1 MB
    //Beats
    //76.71%
    static int findTargetSumWays(int[] nums, int target) {
        int[] arr = new int[1];
        findExpressions(0, 0, nums, target, arr);
        return arr[0];
    }

    private static void findExpressions(int idx, int sum, int[] nums, int target, int[] arr) {
        if (idx == nums.length) {
            if (sum == target) arr[0]++;
            return;
        }

        sum -= nums[idx];
        findExpressions(idx + 1, sum, nums, target, arr);

        sum += nums[idx] * 2;
        findExpressions(idx + 1, sum, nums, target, arr);
    }
}
