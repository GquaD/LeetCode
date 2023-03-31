package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2501 {
    //https://leetcode.com/problems/longest-square-streak-in-an-array/description/
    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{4,3,6,16,8,2}));
        System.out.println(longestSquareStreak(new int[]{2,3,5,6,7}));
        System.out.println(longestSquareStreak(new int[]{4, 3}));
    }

    //https://leetcode.com/problems/longest-square-streak-in-an-array/solutions/3361244/java-using-set/
    //15 min
    //Runtime
    //41 ms
    //Beats
    //88.59%
    //Memory
    //63 MB
    //Beats
    //8.72%
    static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int streak = -1;
        for (int n : nums) {
            int temp = n, count = 1;
            while (set.contains((int)Math.min(Integer.MAX_VALUE, 1L * temp * temp))) {
                temp *= temp;
                count++;
            }
            if (count > 1 && streak < count) {
                streak = count;
            }
        }
        return streak;
    }
}
