package LeetCode.easy;

public class Problem4097 {
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Memory
    //44.48
    //MB
    //Beats
    //100.00%
    public int minMergedInteger(int[] nums) {
        int min = merge(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i += 2) min = Math.min(min, merge(nums[i], nums[i + 1]));

        return min;
    }

    private int merge(int a, int b) {
        if (b <= 9) {
            return a * 10 + b;
        } else if (b <= 99) {
            return a * 100 + b;
        } else if (b <= 999) {
            return a * 1000 + b;
        } else {
            return a * 10000 + b;
        }
    }
}
