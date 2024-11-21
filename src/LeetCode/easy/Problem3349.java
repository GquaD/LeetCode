package LeetCode.easy;

import java.util.List;

public class Problem3349 {
    //https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/solutions/6068300/java-100-faster-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.32
    //MB
    //Beats
    //69.14%
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            boolean increasing = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    increasing = false;
                    break;
                }
            }
            if (!increasing) continue;
            for (int j = i + k; j < i + 2 * k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    increasing = false;
                    break;
                }
            }
            if (increasing) return true;
        }
        return false;
    }
}
