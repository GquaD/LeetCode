package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2200 {
    //https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
    public static void main(String[] args) {
        LeetCodeUtils.printList(findKDistantIndices(new int[]{1}, 1, 1));
        LeetCodeUtils.printList(findKDistantIndices(new int[]{3,5,4,9,1,3,9,5}, 3, 1));
        LeetCodeUtils.printList(findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
        LeetCodeUtils.printList(findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2));
    }

    //https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/solutions/2838117/java-using-linkedhashset/
    //Runtime
    //109 ms
    //Beats
    //27.47%
    //Memory
    //42.8 MB
    //Beats
    //89.81%
    static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int end = Math.min(i + k, nums.length - 1);
                for (int j = Math.max(i - k, 0); j <= end; j++) {
                    set.add(j);
                }
            }
        }
        return new ArrayList<>(set);
    }

    static List<Integer> findKDistantIndices1(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = k; i < nums.length - k; i++) {
            for (int j = i - k; j <= i + k; j++) {
                if (nums[j] == key) {
                    for (int l = i - k; l < i + k; l++) {
                        set.add(l);
                    }
                    break;
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}
