package LeetCode.medium;

import java.util.*;

public class Problem229 {
    //https://leetcode.com/problems/majority-element-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/majority-element-ii/solutions/3205077/java-weird-solution-using-random/
    //does not solve 100% times
    //Runtime
    //2 ms
    //Beats
    //72.31%
    //Memory
    //46.3 MB
    //Beats
    //45.96%
    static List<Integer> majorityElement(int[] nums) {
        if (nums.length < 60) return majorityElement1(nums);
        Set<Integer> setIds = new HashSet<>();
        while (setIds.size() < 30) {
            setIds.add((int) (Math.random() * nums.length));
        }
        int[] arr = new int[setIds.size()];
        int count = 0;
        for (int i : setIds) arr[count++] = nums[i];
        return majorityElement1(arr);
    }

    //5 min
    //Runtime
    //9 ms
    //Beats
    //42.17%
    //Memory
    //45.7 MB
    //Beats
    //74.80%
    static List<Integer> majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }
        int indicator = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet())
            if (map.get(key) > indicator) list.add(key);
        return list;
    }
}
