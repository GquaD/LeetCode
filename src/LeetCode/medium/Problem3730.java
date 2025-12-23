package LeetCode.medium;

import java.util.Arrays;

public class Problem3730 {
    //https://leetcode.com/problems/maximum-calories-burnt-from-jumps/description/
    //5-10min
    //Runtime
    //54
    //ms
    //Beats
    //62.12%
    //Analyze Complexity
    //Memory
    //112.78
    //MB
    //Beats
    //21.97%
    public long maxCaloriesBurnt(int[] heights) {
        Arrays.sort(heights);
        long result = 0, prev = 0;
        for (int i = 0; i < heights.length / 2; i++) {
            long cur = heights[heights.length - i - 1];
            long diff = Math.abs(prev - cur);
            result += diff * diff;
            prev = cur;

            cur = heights[i];
            diff = Math.abs(prev - cur);
            result += diff * diff;
            prev = cur;
        }

        if (heights.length % 2 == 1) {
            long cur = heights[heights.length / 2];
            long diff = Math.abs(prev - cur);
            result += diff * diff;
        }

        return result;
    }
}
