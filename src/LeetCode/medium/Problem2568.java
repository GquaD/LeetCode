package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2568 {
    //https://leetcode.com/problems/minimum-impossible-or/
    public static void main(String[] args) {
        System.out.println(minImpossibleOR(new int[]{2,1}));
        System.out.println(minImpossibleOR(new int[]{5,3,2}));
    }

    //https://leetcode.com/problems/minimum-impossible-or/solutions/3306148/java-solution-using-set/
    //30 min
    //Runtime
    //28 ms
    //Beats
    //31.61%
    //Memory
    //55 MB
    //Beats
    //59.93%
    static int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (max < nums[i]) max = nums[i];
        }
        int start = 1;
        while (start <= max) {
            if (!set.contains(start)) return start;
            else start *= 2;
        }
        return start;
    }


    static int minImpossibleOR1(int[] nums) {
        int or = 0, pow = 0;
        boolean hasOne = false;
        for (int n : nums) {
            or |= n;
            if (n == 1) hasOne = true;
        }
        String bin = Integer.toBinaryString(or);
        if (!hasOne) return 1;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) != '0') pow++;
            else break;
        }
        return  (int) Math.pow(2, pow);
    }
}
