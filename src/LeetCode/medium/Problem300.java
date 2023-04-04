package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem300 {
    //https://leetcode.com/problems/longest-increasing-subsequence/description/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //8 ms
    //Beats
    //77.20%
    //Memory
    //42.5 MB
    //Beats
    //35.22%
    static int lengthOfLIS1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (list.isEmpty() || list.get(list.size() - 1) < n) {
                list.add(n);
            } else {
                int idx = Collections.binarySearch(list, n);
                if (idx < 0) idx = -idx - 1;
                list.set(idx, n);
            }
        }
        return list.size();
    }

    //nnnn
    //Runtime
    //71 ms
    //Beats
    //41.98%
    //Memory
    //42.1 MB
    //Beats
    //63.96%
    static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
        return Arrays.stream(dp).max().getAsInt() + 1;
    }
}
