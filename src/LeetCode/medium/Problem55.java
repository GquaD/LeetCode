package LeetCode.medium;

public class Problem55 {
    //https://leetcode.com/problems/jump-game/description/
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }

    //https://leetcode.com/problems/jump-game/solutions/2952285/java-o-n-2-ms-solution/
    //Runtime
    //2 ms
    //Beats
    //92.42%
    //Memory
    //43 MB
    //Beats
    //78.17%
    static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int max = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (max == 0) return false;
            max--;
            max = Math.max(max, nums[i]);
        }
        return max > 0;
    }
}
