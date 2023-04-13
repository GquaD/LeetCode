package LeetCode.medium;

public class Problem413 {
    //https://leetcode.com/problems/arithmetic-slices/
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 8, 5, 6, 7,8,9}));
    }

    //https://leetcode.com/problems/arithmetic-slices/solutions/3411204/java-o-n-0ms-100-faster-explained/
    //25 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.6 MB
    //Beats
    //44.2%
    static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0, diff = nums[1] - nums[0], count = 1;
        for (int i = 2; i < nums.length; i++) {
            int prev = nums[i - 1], curr = nums[i];
            if (curr - prev == diff) {
                count++;
            } else {
                if (--count > 0) {
                    res += ((1 + count) * count) / 2;
                }
                count = 1;
                diff = curr - prev;
            }
        }
        if (--count > 0) res += ((1 + count) * count) / 2;
        return res;
    }
}
