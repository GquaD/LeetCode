package LeetCode.medium;

public class Problem2871 {
    //https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays/
    public static void main(String[] args) {
        System.out.println(maxSubarrays(new int[]{22,21,29,22}));
        System.out.println(maxSubarrays(new int[]{1,0,2,0,1,2}));
        System.out.println(maxSubarrays(new int[]{5,7,1,3}));
    }

    //https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays/solutions/4243739/java-o-n-100-faster-greedy/
    //10-15min
    //Runtime
    //3 ms
    //Beats
    //100%
    //Memory
    //56.2 MB
    //Beats
    //46.7%
    static int maxSubarrays(int[] nums) {
        if (nums.length == 1) return 1;
        int andMax = nums[0], count = 0, currAnd = nums[0], sum = 0;
        for (int n : nums) andMax &= n;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (currAnd <= andMax) {
                count++;
                sum += currAnd;
                currAnd = n;
            }
            currAnd &= n;
        }
        if (currAnd <= andMax) {
            count++;
            sum += currAnd;
        }
        return sum <= andMax ? count : 1;
    }
}
