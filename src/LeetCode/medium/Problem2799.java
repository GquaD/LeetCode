package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2799 {
    //https://leetcode.com/problems/count-complete-subarrays-in-an-array/
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{1917,1917,608,608,1313,751,558,1561,608}));
        System.out.println(countCompleteSubarrays(new int[]{459,459,962,1579,1435,756,1872,1597}));
        System.out.println(countCompleteSubarrays(new int[]{1,3,1,2,2}));
        System.out.println(countCompleteSubarrays(new int[]{5,5,5,5}));
    }

    //nnnn
    //Runtime
    //7 ms
    //Beats
    //90.80%
    //Memory
    //43.5 MB
    //Beats
    //92.26%
    static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int distinct = set.size(), count = 0, l = 0;
        if (distinct == 1) return ((1 + nums.length) * nums.length) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.getOrDefault(curr, 0) == 0) distinct--;
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (distinct == 0) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) distinct++;
                l++;
            }
            count += l;

        }
        return count;
    }

    //Wrong Answer
    //978 / 1074 testcases passed
    static int countCompleteSubarrays1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int distinct = set.size(), count = 1, l = 0, r = 0;
        if (distinct == 1) return ((1 + nums.length) * nums.length) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //if (distinct == map.size())
            while (map.size() == distinct) {
                if (!(l == 0 && i == nums.length - 1)) count++;
                if (l + 1 > i) break;
                int n = nums[l++];
                if (map.get(n) <= 1) {
                    l--;
                    break;
                }
                else map.put(n, map.get(n) - 1);
            }

        }
        return count;
    }
}
