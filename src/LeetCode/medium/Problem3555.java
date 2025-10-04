package LeetCode.medium;

import java.util.Arrays;

public class Problem3555 {
    //https://leetcode.com/problems/smallest-subarray-to-sort-in-every-sliding-window/
    public static void main(String[] args) {

    }

    //Runtime
    //212
    //ms
    //Beats
    //71.43%
    //Analyze Complexity
    //Memory
    //45.93
    //MB
    //Beats
    //14.29%
    //15min
    public int[] minSubarraySort(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1], temp = new int[k];
        int idx = 0, a = -1, b = -1;
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                temp[j - i] = nums[j];
            }
            Arrays.sort(temp);
            for (int j = i; j < i + k; j++) {
                if (temp[j - i] != nums[j]) {
                    a = j;
                    break;
                }
            }
            for (int j = i + k - 1; j >= i; j--) {
                if (temp[j - i] != nums[j]) {
                    b = j;
                    break;
                }
            }
            result[idx++] = a == -1 && b == -1 ? 0 : b - a + 1;
            a = b = -1;
        }
        return result;
    }
}
