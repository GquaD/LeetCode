package LeetCode.easy;

public class Problem1913 {
    //https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5,6,2,7,4}));
        System.out.println(maxProductDifference(new int[]{4,2,5,9,7,4,8}));
        System.out.println(maxProductDifference(new int[]{1,6,7,5,2,4,10,6,4})); //68
        System.out.println(maxProductDifference(new int[]{8,3,5,7})); //41
    }

    //Runtime: 2 ms, faster than 99.13% of Java online submissions for Maximum Product Difference Between Two Pairs.
    //Memory Usage: 54.5 MB, less than 16.61% of Java online submissions for Maximum Product Difference Between Two Pairs.
    static int maxProductDifference(int[] nums) {
        int max = 0, maxNext = 0, min = 10000, minNext = 10000;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (max < n) {
                maxNext = max;
                max = n;
            } else if (maxNext < n) {
                maxNext = n;
            }

            if (min > n) {
                minNext = min;
                min = n;
            } else if (minNext > n) {
                minNext = n;
            }
        }
        return (max * maxNext) - (min * minNext);
    }
}
