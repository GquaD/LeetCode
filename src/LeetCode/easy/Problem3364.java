package LeetCode.easy;

import java.util.List;

public class Problem3364 {
    //https://leetcode.com/problems/minimum-positive-sum-subarray/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-positive-sum-subarray/solutions/6088740/java-sliding-window-solution/
    //3min
    //Runtime
    //3
    //ms
    //Beats
    //90.66%
    //Analyze Complexity
    //Memory
    //44.42
    //MB
    //Beats
    //55.89%
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = 100_000;
        for (int size = l; size <= r; size++) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += nums.get(i);
            }
            if (sum > 0) min = Math.min(min, sum);
            for (int i = size; i < nums.size(); i++) {
                sum -= nums.get(i - size);
                sum += nums.get(i);
                if (sum > 0) min = Math.min(min, sum);
            }
        }
        return min == 100_000 ? -1 : min;
    }
}
