package LeetCode.medium;

public class Problem1004 {
    //https://leetcode.com/problems/max-consecutive-ones-iii/description/
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

    //nnnn
    //Runtime
    //3 ms
    //Beats
    //77.66%
    //Memory
    //47.1 MB
    //Beats
    //15.77%
    static int longestOnes(int[] nums, int k) {
        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }
        return j - i;
    }
}
