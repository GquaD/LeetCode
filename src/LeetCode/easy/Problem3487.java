package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem3487 {
    //https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/solutions/6559137/java-1ms-100-faster-solution-explained-b-2liy/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.26
    //MB
    //Beats
    //95.78%
    public int maxSum(int[] nums) {
        int res = 0, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (n > 0 && !set.contains(n)) {
                res += n;
                set.add(n);
            } else if (n <= 0) {
                max = Math.max(max, n);
            }
        }
        return res == 0 ? max : res;
    }
}
