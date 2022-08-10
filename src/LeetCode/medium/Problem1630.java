package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1630 {
    //https://leetcode.com/problems/arithmetic-subarrays/
    public static void main(String[] args) {
        LeetCodeUtils.printList(checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}));
        LeetCodeUtils.printList(checkArithmeticSubarrays(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10}));
    }

    //Runtime: 31 ms, faster than 61.83% of Java online submissions for Arithmetic Subarrays.
    //Memory Usage: 54.6 MB, less than 57.80% of Java online submissions for Arithmetic Subarrays.
    static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            int count = 0;
            for (int j = l[i]; j <= r[i]; j++) {
                arr[count++] = nums[j];
            }
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            boolean res = true;
            for (int j = 2; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != diff) {
                    res = false;
                    break;
                }
            }
            list.add(res);
        }
        return list;
    }
}
