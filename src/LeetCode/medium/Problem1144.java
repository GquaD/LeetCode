package LeetCode.medium;

public class Problem1144 {
    //https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{2, 1, 2}));
        System.out.println(movesToMakeZigzag(new int[]{1, 2, 3}));
        System.out.println(movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    //https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/solutions/3963404/java-o-n-100-faster-solution/
    //15-20min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //20.59%
    static int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 0;
        int sum = 0, prev = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i += 2) {
            int diff = nums[i] - Math.min(i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1], prev);
            if (diff >= 0) sum += diff + 1;
            prev = i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1];
        }
        int sum2 = 0, prev2 = nums[0];
        for (int i = 1; i < nums.length; i += 2) {
            int diff = nums[i] - Math.min(i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1], prev2);
            if (diff >= 0) sum2 += diff + 1;
            prev2 = i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1];
        }
        return Math.min(sum, sum2);
    }
}
