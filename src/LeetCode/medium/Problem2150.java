package LeetCode.medium;

import java.util.*;

public class Problem2150 {
    //https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/solutions/4085503/java-from-80ms-to-31ms/
    //5-10min
    //Runtime
    //31 ms
    //Beats
    //80.73%
    //Memory
    //59.3 MB
    //Beats
    //90.65%
    static List<Integer> findLonely(int[] nums) {
        if (nums.length == 1) return Arrays.asList(nums[0]);
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length - 1; i++) if (nums[i] - nums[i - 1] > 1 && nums[i + 1] - nums[i] > 1) list.add(nums[i]);
        if (nums[1] - nums[0] > 1) list.add(nums[0]);
        if (nums[nums.length - 1] - nums[nums.length - 2] > 1) list.add(nums[nums.length - 1]);
        return list;
    }

    //2min
    //Runtime
    //80 ms
    //Beats
    //26.72%
    //Memory
    //63.2 MB
    //Beats
    //32.25%
    static List<Integer> findLonely1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int n : nums) if (map.get(n) == 1 && !map.containsKey(n - 1) && !map.containsKey(n + 1)) list.add(n);
        return list;
    }
}
