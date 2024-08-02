package LeetCode.medium;

public class Problem2134 {
    //https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii


    //expl
    //10min
    //Runtime
    //12
    //ms
    //Beats
    //22.69%
    //Analyze Complexity
    //Memory
    //61.72
    //MB
    //Beats
    //10.03%
    public int minSwaps(int[] nums) {
        int[] arr = new int[nums.length * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i % nums.length];
        }
        int amount1 = 0;
        for (int n : nums) if (n == 1) amount1++;
        int count1 = 0;
        for (int i = 0; i < amount1; i++) {
            if (arr[i] == 1) count1++;
        }
        int minSwaps = amount1 - count1;
        for (int i = amount1; i < arr.length; i++) {
            if (arr[i] == 1) count1++;
            if (arr[i - amount1] == 1) count1--;
            minSwaps = Math.min(minSwaps, amount1 - count1);
        }
        return minSwaps;
    }
}
