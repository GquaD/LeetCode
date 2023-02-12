package LeetCode.easy;

public class Problem2016 {
    //https://leetcode.com/problems/maximum-difference-between-increasing-elements
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.5 MB
    //Beats
    //75.92%
    static int maximumDifference(int[] nums) {
        int min = nums[0], answer = -1;
        for (int i = 1; i < nums.length; i++) {
            answer = Math.max(answer, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return answer == 0 ? -1 : answer;
    }
}
