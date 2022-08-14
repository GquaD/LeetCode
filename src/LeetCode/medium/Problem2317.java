package LeetCode.medium;

public class Problem2317 {
    //https://leetcode.com/problems/maximum-xor-after-operations/
    public static void main(String[] args) {
        System.out.println(maximumXOR(new int[]{3, 2, 4, 6}));
        System.out.println(maximumXOR(new int[]{1, 2, 3, 9, 2}));
    }

    //Runtime: 2 ms, faster than 76.15% of Java online submissions for Maximum XOR After Operations .
    //Memory Usage: 77.2 MB, less than 31.06% of Java online submissions for Maximum XOR After Operations .
    static int maximumXOR(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            result |= nums[i];
        }
        return result;
    }

    //wrong
    static int maximumXOR1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int secondMax = max;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
            }
        }

        int count = 0, countSecond = 0;
        count = findNumberOfDigits(max);
        countSecond = findNumberOfDigits(secondMax);
        int result = (int) Math.pow(2, count - 1);
        if (count == countSecond) {
            countSecond--;
        }
        for (int i = 0; i < countSecond; i++) {
            result += Math.pow(2, i);
        }
        return result;
    }

    private static int findNumberOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            n /= 2;
            count++;
        }
        return count;
    }
}
