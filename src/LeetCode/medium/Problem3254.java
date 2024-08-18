package LeetCode.medium;

public class Problem3254 {
    //https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/


    //https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/solutions/5655394/java-o-n-100-faster-solution/
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.99
    //MB
    //Beats
    //100.00%
    public int[] resultsArray(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            boolean isGood = true;
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] - nums[j - 1] != 1) {
                    isGood = false;
                    break;
                }
                max = Math.max(max, nums[j]);
            }
            arr[i] = isGood ? max : -1;
        }
        return arr;
    }
}
