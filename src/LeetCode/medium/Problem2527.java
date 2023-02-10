package LeetCode.medium;

public class Problem2527 {
    //https://leetcode.com/problems/find-xor-beauty-of-array/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-xor-beauty-of-array/solutions/3166735/java-iterative-solution/
    //10 min
    //Runtime
    //2 ms
    //Beats
    //8.86%
    //Memory
    //58.6 MB
    //Beats
    //81.97%
    static int xorBeauty(int[] nums) {
        int xor = -1;
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i+=2) {
            int a = nums[i - 1], b = nums[i];
            if (xor == -1) xor = a ^ 0 ^ a ^ b ^ a ^ b ^ 0 ^ b;
            else xor ^= a ^ 0 ^ a ^ b ^ a ^ b ^ 0 ^ b;
        }
        return nums.length % 2 == 1 ? xor - nums[nums.length - 1] : xor;
    }
}
