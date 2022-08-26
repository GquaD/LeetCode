package LeetCode;

public class Problem1991 {
    //https://leetcode.com/problems/find-the-middle-index-in-array/
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
        System.out.println(findMiddleIndex(new int[]{1, -1, 4}));
        System.out.println(findMiddleIndex(new int[]{2, 5}));
    }

    //Runtime: 1 ms, faster than 87.46% of Java online submissions for Find the Middle Index in Array.
    //Memory Usage: 42.3 MB, less than 61.38% of Java online submissions for Find the Middle Index in Array.
    static int findMiddleIndex(int[] nums) {
        int sumRight = 0;
        for (int i = 0; i < nums.length; i++) {
            sumRight += nums[i];
        }
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumLeft == sumRight - nums[i]) {
                return i;
            } else {
                sumRight -= nums[i];
                sumLeft += nums[i];
            }
        }
        return -1;
    }

    static int findMiddleIndex1(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < len / 2; i++) {
            sumLeft += nums[i];
            if (sumLeft == sumRight && i + 1 == len - 1 - i) {
                return i + 1;
            }
            sumRight += nums[len - i - 1];
            if (sumLeft == sumRight && i + 1 == len - 2 - i) {
                return i + 1;
            }
        }
        return -1;
    }
}
