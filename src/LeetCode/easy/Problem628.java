package LeetCode.easy;

import java.util.Arrays;

public class Problem628 {
    //https://leetcode.com/problems/maximum-product-of-three-numbers/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-product-of-three-numbers/solutions/3587046/java-simple-solution/
    //2 min
    //Runtime
    //13 ms
    //Beats
    //61.66%
    //Memory
    //45.2 MB
    //Beats
    //12.65%
    static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0], b = nums[1], c = nums[nums.length - 3], d = nums[nums.length - 2], f = nums[nums.length - 1];
        if (a < 0 && b < 0) a = a * b * f;
        f = c * d * f;
        return Math.max(a, f);
    }
}
