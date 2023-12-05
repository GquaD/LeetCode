package LeetCode.medium;

import java.util.Arrays;

public class Problem453 {
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{-10, 3, 5, 10}));
        System.out.println(minMoves(new int[]{1,2,3}));
        System.out.println(minMoves(new int[]{1,1,1}));
    }

    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements/solutions/4365765/java-o-nlogn-solution/
    //10 min
    //Runtime
    //12 ms
    //Beats
    //29.40%
    //Memory
    //43.8 MB
    //Beats
    //71.30%
    static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0, count = 1;
        for (int i = nums.length - 1; i > 0 ; i--) res += (nums[i] - nums[i - 1]) * count++;
        return res;
    }
}
