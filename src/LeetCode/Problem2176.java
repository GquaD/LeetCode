package LeetCode;

public class Problem2176 {
    //https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3,1,2,2,2,1,3}, 2));
        System.out.println(countPairs(new int[]{1,2,3,4}, 1));
    }

    //Runtime: 6 ms, faster than 38.75% of Java online submissions for Count Equal and Divisible Pairs in an Array.
    //Memory Usage: 43 MB, less than 59.91% of Java online submissions for Count Equal and Divisible Pairs in an Array.
    static int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
