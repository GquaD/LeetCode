package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2389 {
    //https://leetcode.com/problems/longest-subsequence-with-limited-sum/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
    }

    //Runtime
    //5 ms
    //Beats
    //96.90%
    //Memory
    //42.7 MB
    //Beats
    //97.25%
    static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] < nums[0]) {
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                if (queries[i] < nums[j]) {
                    result[i] = j;
                    break;
                }
            }
            if (result[i] == 0) {
                result[i] = nums.length;
            }
        }
        return result;
    }
}
