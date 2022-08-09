package LeetCode;

public class Problem1413 {
    //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-5,-2,4,4,-2}));//[-5,-2,4,4,-2]
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
        System.out.println(minStartValue(new int[]{1,2}));
        System.out.println(minStartValue(new int[]{1,-2,-3}));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
    //Memory Usage: 39.6 MB, less than 93.38% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
    static int minStartValue(int[] nums) {
        int sumSoFar = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            if (minSum > sumSoFar) {
                minSum = sumSoFar;
            }
        }
        return 1 - minSum;
    }
    static int minStartValue2(int[] nums) {
        boolean noNeg = true;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (noNeg && nums[i] < 1) {
                noNeg = false;
            }
            if (!noNeg) {
                sum += nums[i];
            }
        }
        return sum >= 1 ? 1 : 1 - sum;
    }

    static int minStartValue1(int[] nums) {
        int indexOfLastNegative = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                indexOfLastNegative = i;
            }
        }
        int minStartValue = 1;
        int sumSoFar = 0;
        int sumTempBeforeEnd = 0;
        int negSum = 0;
        int countNeg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                negSum += nums[i];
                countNeg++;
            }
            if (countNeg > 0 && nums[i] > 0) {
                sumSoFar += nums[i];
            }

        }
        return 1;
    }
}
