package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3265 {
    //https://leetcode.com/problems/count-almost-equal-pairs-i/
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3,12,30,17,21}));
    }

    //https://leetcode.com/problems/count-almost-equal-pairs-i/solutions/5740887/java-bruteforce-solution/
    //1hour
    //Runtime
    //35
    //ms
    //Beats
    //70.45%
    //Analyze Complexity
    //Memory
    //44.60
    //MB
    //Beats
    //94.48%
    public static int countPairs(int[] nums) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(variations(nums[i]));
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] || list.get(i).contains(nums[j]) || list.get(j).contains(nums[i]))
                    count++;
            }
        }
        return count;
    }

    private static Set<Integer> variations(int n) {
        String s = n + "";
        Set<Integer> set = new HashSet<>();
        if (s.length() == 1) {
            set.add(n);
            return set;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                char[] arr = s.toCharArray();
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                set.add(Integer.parseInt(String.valueOf(arr)));
            }
        }
        return set;
    }
}
