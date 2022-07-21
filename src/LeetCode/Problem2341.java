package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2341 {
    //https://leetcode.com/problems/maximum-number-of-pairs-in-array/submissions/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[] {1,3,2,1,3,2,2})));
        System.out.println(Arrays.toString(numberOfPairs(new int[] {1,1})));
        System.out.println(Arrays.toString(numberOfPairs(new int[] {0})));
    }

    //Runtime: 3 ms, faster than 40.00% of Java online submissions for Maximum Number of Pairs in Array.
    //Memory Usage: 43 MB, less than 40.00% of Java online submissions for Maximum Number of Pairs in Array.
    static int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            int v = map.get(key);
            res[0] += v / 2;
            res[1] += v % 2;
        }
        return res;
    }

}
