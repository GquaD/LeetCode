package LeetCode;

import java.util.*;

public class Problem1 {
    //https://leetcode.com/problems/two-sum/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{0, 4, 3, 0}, 0)));
        System.out.println(Arrays.toString(twoSum(new int[]{-3, 4, 3, 90}, 0)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 4, 2, 90}, 4)));
    }

    //Runtime: 15 ms, faster than 47.02% of Java online submissions for Two Sum.
    //Memory Usage: 49.4 MB, less than 5.25% of Java online submissions for Two Sum.
    //https://leetcode.com/problems/two-sum/discuss/2474504/Java-O(N)-Solution-(in-15-ms)-Explained
    static int[] twoSum(int[] nums, int target) {
        //number -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            List<Integer> list;
            if (map.containsKey(key)) {
                list = map.get(key);
                if (list.size() < 2) {
                    list.add(i);
                    map.put(key, list);
                }
            } else {
                list = new LinkedList<>();
                list.add(i);
                map.put(key, list);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(target - key) != null && (map.get(key).size() == 2 && key + key == target)) {
                List<Integer> list = map.get(key);
                return new int[]{list.get(0), list.get(1)};
            }
            if (map.get(target - key) != null && target != key) {
                int one = map.get(key).get(0);
                int two = map.get(target - key).get(0);
                int min = Math.min(one, two);
                int max = Math.max(one, two);
                return new int[]{min, max};
            }
        }
        return null;
    }

    //Runtime: 1209 ms, faster than 5.01% of Java online submissions for Two Sum.
    //Memory Usage: 46.1 MB, less than 22.79% of Java online submissions for Two Sum.
    static int[] twoSum3(int[] nums, int target) {
        //number -> index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            for (Integer key : map.keySet()) {
                if (key + nums[i] == target) {
                    return new int[]{map.get(key), i};
                }
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    //Runtime: 140 ms, faster than 7.47% of Java online submissions for Two Sum.
    //Memory Usage: 44.3 MB, less than 83.97% of Java online submissions for Two Sum.
    static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //Runtime: 282 ms, faster than 5.01% of Java online submissions for Two Sum.
    //Memory Usage: 45.3 MB, less than 48.68% of Java online submissions for Two Sum.
    static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
