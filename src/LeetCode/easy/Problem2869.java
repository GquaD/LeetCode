package LeetCode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2869 {
    //https://leetcode.com/problems/minimum-operations-to-collect-elements/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-operations-to-collect-elements/solutions/6005917/java-one-pass-hashset-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //95.60%
    //Analyze Complexity
    //Memory
    //41.93
    //MB
    //Beats
    //64.61%
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            int n = nums.get(i);
            if (n <= k) set.add(n);
            if (set.size() == k) return nums.size() - i;
        }
        return nums.size();
    }
}
