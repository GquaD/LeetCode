package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.Arrays;

public class Problem2966 {
    //https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2));
        LeetCodeUtils.print2DArray(divideArray(new int[]{1,3,3,2,7,3}, 3));
    }

    //https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/solutions/4416619/java-o-nlogn-solution/
    //5min
    //Runtime
    //23 ms
    //Beats
    //33.33%
    //Memory
    //55.6 MB
    //Beats
    //100%
    static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] arr = new int[nums.length / 3][3];
        for (int i = 2; i < nums.length; i += 3) {
            int a = nums[i - 2], c = nums[i];
            if (c - a > k) {
                return new int[0][0];
            }
            int idx = i / 3, b = nums[i - 1];
            arr[idx][0] = a;
            arr[idx][1] = b;
            arr[idx][2] = c;
        }
        return arr;
    }
}
