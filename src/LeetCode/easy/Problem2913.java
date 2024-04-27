package LeetCode.easy;

import java.util.*;

public class Problem2913 {
    //https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
    public static void main(String[] args) {
        System.out.println(sumCounts(Arrays.asList(1,2,1)));
        System.out.println(sumCounts(Arrays.asList(1,1)));
    }

    //10min
    //Runtime
    //98
    //ms
    //Beats
    //33.11%
    //of users with Java
    //Memory
    //44.48
    //MB
    //Beats
    //77.53%
    //of users with Java
    public static int sumCounts(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 1; i <= nums.size(); i++) {
            for (int j = 0; j <= nums.size() - i; j++) {
                for (int k = j; k < j + i; k++) {
                    set.add(nums.get(k));
                }
                int size = set.size();
                res += size * size;
                set.clear();
            }
        }
        return res;
    }

    static int sumCounts2(List<Integer> nums) {
        return recursive(0, nums.size() - 1, nums, new HashSet<>());
    }

    private static int recursive(int a, int b, List<Integer> nums, Set<Integer> set) {
        if (a >= nums.size() || b < 0) return 0;
        for (int i = a; i <= b; i++) set.add(nums.get(i));
        int score = set.size() * set.size();
        set.clear();
        return score + recursive(a, b - 1, nums, set) + recursive(a + 1, b, nums, set);
    }


    static int sumCounts1(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                for (int k = i + j; k < nums.size(); k++) {
                    set.add(nums.get(k));
                }
                res += set.size() * set.size();
                set.clear();
            }
        }
        return res;
    }
}
