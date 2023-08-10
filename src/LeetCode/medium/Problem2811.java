package LeetCode.medium;

import java.util.List;

public class Problem2811 {
    //https://leetcode.com/problems/check-if-it-is-possible-to-split-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-it-is-possible-to-split-array/solutions/3892018/java-2-lines-100-faster-solution/
    //10 min
    //Runtime
    //1 ms
    //Beats
    //99.50%
    //Memory
    //42.5 MB
    //Beats
    //92.45%
    static boolean canSplitArray(List<Integer> nums, int m) {
        for (int i = 0; i < nums.size() - 1; i++) if (nums.get(i) + nums.get(i + 1) >= m) return true;
        return nums.size() < 3;
    }

    static boolean canSplitArray1(List<Integer> nums, int m) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) sum += nums.get(i);
        int l = 0, r = nums.size() - 1;
        while (l <= r) {

        }
        return true;
    }
}
