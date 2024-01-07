package LeetCode.medium;

public class Problem10032 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/submissions/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/solutions/4523809/java-100-100/
    //5-10min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //55.4 MB
    //Beats
    //100%
    static int minOperations(int[] nums, int k) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        xor ^= k;
        int count = 0;
        while (xor > 0) {
            if (xor % 2 == 1) count++;
            xor = xor >> 1;
        }

        return count;
    }
}
