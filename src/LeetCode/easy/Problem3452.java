package LeetCode.easy;

public class Problem3452 {
    //https://leetcode.com/problems/sum-of-good-numbers/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/sum-of-good-numbers/solutions/6430062/java-on-100-faster-solution-by-tbekpro-egbe/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.95
    //MB
    //Beats
    //100.00%
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean good = true;
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                continue;
            } else if (i + k < nums.length && nums[i] <= nums[i + k]) {
                continue;
            }
            sum += nums[i];
        }

        return sum;
    }
}
