package LeetCode.medium;

import java.util.*;

public class Problem532 {
    //https://leetcode.com/problems/k-diff-pairs-in-an-array/
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 0));
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

    //https://leetcode.com/problems/k-diff-pairs-in-an-array/solutions/4182045/java-straightforward-solution/
    //30 min
    //Runtime
    //31 ms
    //Beats
    //12.46%
    //Memory
    //44.6 MB
    //Beats
    //16.1%
    static int findPairs(int[] nums, int k) {
        int count = 0;
        if (k == 0) {
            Map<Integer, Integer> mapFreq = new TreeMap<>();
            for (int n : nums) mapFreq.put(n, mapFreq.getOrDefault(n, 0) + 1);
            for (int key : mapFreq.keySet()) count += mapFreq.get(key) > 1 ? 1 : 0;
            return count;
        }
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int i1 = Arrays.binarySearch(nums, n - k), i2 = Arrays.binarySearch(nums, n + k);
            String s1 = (n - k) + "_" + n, s2 = n + "_" + (n + k);
            if (i != i1 && i1 >= 0 && !set.contains(s1)) count++;
            set.add(s1);
            if (i != i2 && i2 >= 0 && !set.contains(s2)) count++;
            set.add(s2);
        }
        return count;
    }
}
