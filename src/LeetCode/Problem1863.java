package LeetCode;

public class Problem1863 {
    //https://leetcode.com/problems/sum-of-all-subset-xor-totals/
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3}));
        System.out.println(subsetXORSum(new int[]{5,1,6}));
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8}));
    }

    //Runtime: 1 ms, faster than 83.76% of Java online submissions for Sum of All Subset XOR Totals.
    //Memory Usage: 41.9 MB, less than 33.70% of Java online submissions for Sum of All Subset XOR Totals.
    static int subsetXORSum(int[] nums) {
        return recursiveXOR(nums, 0, 0);
    }

    private static int recursiveXOR(int[] nums, int index, int result) {
        if (index == nums.length) return result;
        return recursiveXOR(nums, index + 1, result ^ nums[index]) + recursiveXOR(nums, index + 1, result);
    }
}
