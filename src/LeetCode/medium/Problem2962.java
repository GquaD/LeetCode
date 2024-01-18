package LeetCode.medium;

public class Problem2962 {
    //https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
    }

    //nnnn
    //Runtime
    //5
    //ms
    //Beats
    //94.21%
    //of users with Java
    //Memory
    //64.28
    //MB
    //Beats
    //7.69%
    //of users with Java
    static long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int n : nums) if (max < n) max = n;

        int cur = 0, i = 0;
        long res = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == max) cur++;
            while (cur >= k) if (nums[i++] == max) cur--;
            res += i;
        }
        return res;
    }
}
