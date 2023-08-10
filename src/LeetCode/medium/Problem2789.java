package LeetCode.medium;

public class Problem2789 {
    //https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/
    public static void main(String[] args) {
        System.out.println(maxArrayValue(new int[]{2,3,7,9,3}));
        System.out.println(maxArrayValue(new int[]{5,3,3}));
    }

    //https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/solutions/3892124/java-o-n-solution/
    //5-10min
    //Runtime
    //4 ms
    //Beats
    //37.98%
    //Memory
    //58 MB
    //Beats
    //60.42%
    static long maxArrayValue(int[] nums) {
        long max = nums[nums.length - 1], sum = max;
        for (int i = nums.length - 2; i >= 0; i--) {
            max = Math.max(sum, max);
            if (nums[i] <= nums[i + 1] || nums[i] <= sum) sum += nums[i];
            else sum = nums[i];
        }
        return Math.max(sum, max);
    }
}
