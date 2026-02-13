package LeetCode.easy;

public class Problem3833 {
    //2min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //46.47
    //MB
    //Beats
    //41.73%
    public int dominantIndices(int[] nums) {
        int sum = 0, result = 0;
        for (int n: nums) sum += n;

        for (int i = 1; i < nums.length; i++) {
            sum -= nums[i - 1];
            if (nums[i - 1] > sum / (nums.length - i))
                result++;
        }
        return result;
    }
}
