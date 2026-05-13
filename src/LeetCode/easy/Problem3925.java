package LeetCode.easy;

public class Problem3925 {
    //1min

    //Runtime
    //1
    //ms
    //Beats
    //99.99%
    //Memory
    //47.37
    //MB
    //Beats
    //55.49%
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) ans[i] = nums[i];
        for (int i = 0; i < nums.length; i++) ans[nums.length + i] = nums[nums.length - 1 - i];

        return ans;
    }
}
