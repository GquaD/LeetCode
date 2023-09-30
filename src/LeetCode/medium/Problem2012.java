package LeetCode.medium;

public class Problem2012 {
    //https://leetcode.com/problems/sum-of-beauty-in-the-array/
    public static void main(String[] args) {
        System.out.println(sumOfBeauties(new int[]{3,48,33,17,21,95,24,67,89,1,50,76,6,32,20,5,1,45,79,81,96,96,15,37,44,63,4,40,58,71,99,78,95,6,34,97,52,80,91,20,61,29,12,85,88,41,14,4,58,17,67,75,100,51,63,66,42,19,44,34,34,78,54,84,3,90,72,18,86,8,33,5,17,21,22,13,59,82,30,66,91,5,32,30,92,57,10,33,11,76,30,80,80,91,47,33}));
        System.out.println(sumOfBeauties(new int[]{1,2,3}));
        System.out.println(sumOfBeauties(new int[]{2,4,6,4}));
        System.out.println(sumOfBeauties(new int[]{3,2,1}));
    }

    //https://leetcode.com/problems/sum-of-beauty-in-the-array/solutions/4109503/java-o-n-array-of-minimums/
    //10-15 min
    //Runtime
    //5 ms
    //Beats
    //99.11%
    //Memory
    //57.6 MB
    //Beats
    //75.22%
    static int sumOfBeauties(int[] nums) {
        int max = nums[0], min = 100_001, score = 0;
        int[] arr = new int[nums.length];
        for (int i = nums.length - 1; i > 1; i--) {
            min = Math.min(nums[i], min);
            arr[i] = min;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (max < nums[i] && nums[i] < arr[i + 1]) score += 2;
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) score++;
            max = Math.max(nums[i], max);
        }
        return score;
    }
}
