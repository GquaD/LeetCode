package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1636 {
    //https://leetcode.com/problems/sort-array-by-increasing-frequency/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    //Runtime: 12 ms, faster than 40.03% of Java online submissions for Sort Array by Increasing Frequency.
    //Memory Usage: 44.6 MB, less than 61.96% of Java online submissions for Sort Array by Increasing Frequency.
    static int[] frequencySort(int[] nums) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).freq += 1;
            } else {
                Pair pair = new Pair();
                pair.key = nums[i];
                pair.freq = 1;
                map.put(nums[i], pair);
            }
        }
        List<Pair> list = new ArrayList<>(map.values());
        list = list.stream()
                .sorted((o1, o2) -> o1.freq == o2.freq ? o2.key - o1.key : o1.freq - o2.freq)
                .collect(Collectors.toList());
        int[] res = new int[nums.length];
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).freq; j++) {
                res[count++] = list.get(i).key;
            }
        }
        return res;
    }

    static class Pair {
        int key;
        int freq;
    }
}
