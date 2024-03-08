package LeetCode.medium;

public class Problem2340 {
    //https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/solutions/4842935/java-o-n-100-faster-solution/
    //10-15min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //56.01
    //MB
    //Beats
    //96.57%
    //of users with Java
    static int minimumSwaps(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] <= nums[1] ? 0 : 1;
        int max = 0, maxi = 0, min = 100_001, mini = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (max <= cur) {
                max = cur;
                maxi = i;
            }

            if (min > cur) {
                min = cur;
                mini = i;
            }
        }
        if (min == max) return 0;
        if (mini < maxi) {
            res += mini + nums.length - maxi - 1;
        } else {
            res += nums.length - maxi - 1 + mini - 1;
        }
        return res;
    }
}
