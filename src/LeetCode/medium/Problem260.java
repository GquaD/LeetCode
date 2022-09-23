package LeetCode.medium;

import java.util.*;

public class Problem260 {
    //https://leetcode.com/problems/single-number-iii/

    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/single-number-iii/discuss/2614187/2-Java-solutions-or-96-memory-efficient-or-3ms
    //15 min
    //Runtime: 3 ms, faster than 50.10% of Java online submissions for Single Number III.
    //Memory Usage: 42.4 MB, less than 95.58% of Java online submissions for Single Number III.
    static int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        byte count = 0;
        if (nums[0] != nums[1]) {
            res[count++] = nums[0];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (!(nums[i] == nums[i - 1] || nums[i] == nums[i + 1])) {
                res[count++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            res[count] = nums[nums.length - 1];
        }
        return res;
    }
    //2-3min
    //Runtime: 14 ms, faster than 11.99% of Java online submissions for Single Number III.
    //Memory Usage: 46.1 MB, less than 24.59% of Java online submissions for Single Number III
    static int[] singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!set.add(n)) {
                set.remove(n);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return new int[]{list.get(0), list.get(1)};
    }
}
