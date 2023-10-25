package LeetCode.medium;

import java.util.Arrays;

public class Problem2905 {
    //https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIndices(new int[]{5, 1, 4, 1}, 2, 2)));
        System.out.println(Arrays.toString(findIndices(new int[]{2, 1}, 0, 0)));
        System.out.println(Arrays.toString(findIndices(new int[]{1, 2, 3}, 2, 4)));
    }

    //https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/solutions/4207348/java-o-n-solution/
    //15-20min
    //Runtime
    //2 ms
    //Beats
    //89.7%
    //Memory
    //57.5 MB
    //Beats
    //59.24%
    static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if (nums.length == indexDifference) return new int[]{-1, -1};
        int numsMax[] = new int[nums.length], numsMin[] = new int[nums.length], min = nums[nums.length - 1],
                max = nums[nums.length - 1], two = Integer.MIN_VALUE, idx = 0, one = 0;
        for (int i = nums.length - 1; i >= indexDifference; i--) {
            max = Math.max(max, nums[i]);
            numsMax[i] = max;

            min = Math.min(min, nums[i]);
            numsMin[i] = min;
        }

        for (int i = 0; i < nums.length - indexDifference; i++) {
            idx = i + indexDifference;
            if (Math.abs(nums[i] - numsMax[idx]) >= valueDifference) {
                one = i;
                two = numsMax[idx];
                break;
            }
            if (Math.abs(nums[i] - numsMin[idx]) >= valueDifference) {
                one = i;
                two = numsMin[idx];
                break;
            }
        }
        for (int i = idx; i < nums.length; i++) {
            if (two == nums[i]) {
                two = i;
                break;
            }
        }

        return two == Integer.MIN_VALUE ? new int[]{-1, -1} : new int[]{one, two};
    }
}
