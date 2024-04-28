package LeetCode.medium;

import java.util.Arrays;

public class Problem2113 {
    //https://leetcode.com/problems/elements-in-array-after-removing-and-replacing-elements/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(elementInNums(new int[]{0,1,2}, new int[][]{{5,1},{5,1},{5,1},{5,1},{5,1}})));
        System.out.println(Arrays.toString(elementInNums(new int[]{5,0}, new int[][]{{5,0},{4,1},{11,1},{233,0}})));
        System.out.println(Arrays.toString(elementInNums(new int[]{2}, new int[][]{{0,0},{1,0},{2,0},{3,0}})));
        System.out.println(Arrays.toString(elementInNums(new int[]{0,1,2}, new int[][]{{0,2},{2,0},{3,2},{5,0}})));
    }

    //https://leetcode.com/problems/elements-in-array-after-removing-and-replacing-elements/solutions/5083872/java-o-n-solution/
    //40min
    //Runtime
    //6
    //ms
    //Beats
    //75.00%
    //of users with Java
    //Memory
    //97.63
    //MB
    //Beats
    //58.33%
    //of users with Java
    static int[] elementInNums(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        if (nums.length == 1) {
            for (int i = 0; i < queries.length; i++) {
                int time = queries[i][0], idx = queries[i][1];
                if (time % 2 == 0) ans[i] = nums[0];
                else ans[i] = -1;
            }
        } else {
            int m = nums.length, cycle = m * 2;
            for (int i = 0; i < queries.length; i++) {
                int time = queries[i][0], idx = queries[i][1];
                int k = time % cycle;
                if (k == m) ans[i] = -1;
                else if (k < m) {
                    if (k + idx < m)
                        ans[i] = nums[k + idx];
                    else
                        ans[i] = -1;
                } else {
                    if (idx < k - m)
                        ans[i] = nums[idx];
                    else
                        ans[i] = -1;
                }
            }
        }
        return ans;
    }

    static int[] elementInNums1(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        if (nums.length == 1) {
            for (int i = 0; i < queries.length; i++) {
                int time = queries[i][0], idx = queries[i][1];
                if (time % 2 == 0) ans[i] = nums[0];
                else ans[i] = -1;
            }
        } else {
            int m = nums.length, cycle = m * 2 + 1;
            for (int i = 0; i < queries.length; i++) {
                int time = queries[i][0], idx = queries[i][1];
                int k = time % cycle;
                if (k == m) ans[i] = -1;
                else if (k < m) {
                    if (k + idx < m)
                        ans[i] = nums[k + idx];
                    else
                        ans[i] = -1;
                } else {
                    if (idx < Math.abs(m - 1 - k))
                        ans[i] = nums[idx];
                    else
                        ans[i] = -1;
                }
            }
        }
        return ans;
    }
}
