package LeetCode.medium;

import java.util.List;

public class Problem3350 {
    //https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/solutions/6030644/java-one-pass-o-n-solution/
    //5-10min
    //Runtime
    //16
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //88.70
    //MB
    //Beats
    //66.67%
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int k = 1, maxK = 1, prevK = 0;
        for (int i = 1; i < nums.size(); i++) {
            int a = nums.get(i - 1), b = nums.get(i);
            if (b > a) k++;
            else {
                maxK = Math.max(maxK, Math.min(k, prevK));
                maxK = Math.max(k/2, maxK);
                prevK = k;
                k = 1;
            }
        }
        maxK = Math.max(maxK, Math.min(k, prevK));
        maxK = Math.max(k/2, maxK);
        return maxK;
    }
}
