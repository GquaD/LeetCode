package LeetCode.medium;

import java.util.TreeMap;

public class Problem2909 {
    //https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{47, 27, 17, 7, 45, 39}));
        System.out.println(minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(minimumSum(new int[]{6, 5, 4, 3, 4, 5}));
    }

    //https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/solutions/4203442/java-treemap-o-nlogn-solution/
    //Runtime
    //166 ms
    //Beats
    //5.2%
    //Memory
    //59.6 MB
    //Beats
    //77.48%
    static int minimumSum(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 2; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int min = nums[0];
        int sumMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int sum = sumMin, right = map.firstEntry().getKey();
            if (min < nums[i] && nums[i] > right) sum = min + nums[i] + right;
            sumMin = Math.min(sum, sumMin);
            min = Math.min(min, nums[i]);
            int next = map.get(nums[i + 1]);
            if (next <= 1) map.remove(nums[i + 1]);
            else map.put(nums[i + 1], next - 1);
        }
        return sumMin == Integer.MAX_VALUE ? -1 : sumMin;
    }
}
