package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem448 {
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    public static void main(String[] args) {
        LeetCodeUtils.printList(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/solutions/2835391/java-99-79-time-99-68-memory-explained/
    //Runtime
    //3 ms
    //Beats
    //99.79%
    //Memory
    //49.9 MB
    //Beats
    //99.68%
    static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] exists = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            exists[nums[i] - 1] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!exists[i])
                list.add(i+1);
        }
        return list;
    }

    //wrong
    static List<Integer> findDisappearedNumbers1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 1) {
                for (int j = 1; j < diff; j++) {
                    list.add(nums[i - 1] + j);
                }
            }
        }
        if (nums[0] != 1) {
            list.add(1);
        }
        if (nums[nums.length - 1] != nums.length) {
            list.add(nums.length);
        }
        return list;
    }
}
