package LeetCode;

public class Problem1464 {
    //https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2}));
        System.out.println(maxProduct(new int[]{1,5,4,5}));
        System.out.println(maxProduct(new int[]{3,7}));
        System.out.println(maxProduct(new int[]{10,2,5,2}));
    }

    //Runtime: 1 ms, faster than 93.30% of Java online submissions for Maximum Product of Two Elements in an Array.
    //Memory Usage: 42.3 MB, less than 81.70% of Java online submissions for Maximum Product of Two Elements in an Array.
    static int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max1 = nums[i];
                index = i;
            }
        }

        nums[index] = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
