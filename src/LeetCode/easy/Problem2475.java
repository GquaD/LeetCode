package LeetCode.easy;

public class Problem2475 {
    //https://leetcode.com/problems/number-of-unequal-triplets-in-array/


    //3 mins
    //Runtime
    //14 ms
    //Beats
    //52.88%
    //Memory
    //41.9 MB
    //Beats
    //44.55%
    static int unequalTriplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
