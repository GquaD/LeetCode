package LeetCode.easy;

public class Problem1979 {
    //https://leetcode.com/problems/find-greatest-common-divisor-of-array/
    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{2,5,6,9,10}));
        System.out.println(findGCD(new int[]{7,5,6,8,3}));
        System.out.println(findGCD(new int[]{3,3}));
    }

    //Runtime: 1 ms, faster than 89.79% of Java online submissions for Find Greatest Common Divisor of Array.
    //Memory Usage: 43.3 MB, less than 75.08% of Java online submissions for Find Greatest Common Divisor of Array.
    static int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int gcd = min;
        while (true) {
            if (max % gcd == 0 && min % gcd == 0 && min != 0) {
                return gcd;
            } else {
                gcd--;
            }
        }
    }
}
