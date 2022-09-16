package LeetCode.easy;

import java.util.*;

public class Problem2248 {
    //https://leetcode.com/problems/intersection-of-multiple-arrays/
    public static void main(String[] args) {

    }

    //Runtime: 8 ms, faster than 50.30% of Java online submissions for Intersection of Multiple Arrays.
    //Memory Usage: 47.6 MB, less than 12.27% of Java online submissions for Intersection of Multiple Arrays.
    static List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (map.containsKey(nums[i][j])) {
                    map.put(nums[i][j], map.get(nums[i][j]) + 1);
                } else {
                    map.put(nums[i][j], 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == nums.length) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}
