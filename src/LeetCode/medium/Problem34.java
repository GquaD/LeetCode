package LeetCode.medium;

import java.util.Arrays;

public class Problem34 {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{3,3,3}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,8,8}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,8,8}, 6)));
    }

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/2656850/my-java-average-solution/
    //took 1.5 - 2 hours
    //Runtime
    //1 ms
    //Beats
    //42.93%
    //Memory
    //47.1 MB
    //Beats
    //58.48%
    static int[] searchRange(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        if (res < 0 || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (res == 0) return new int[]{0, 0};
            else return new int[]{-1, -1};
        }
        int a = res, b = res;
        int left = res - 1;
        while (left >= 0 && nums[left] == target) {
            if (nums[left] == target) {
                a = left;
                left--;
            } else break;
        }
        int right = res + 1;
        while (right < nums.length && nums[right] == target) {
            if (nums[right] == target) {
                b = right;
                right++;
            } else break;
        }

        return new int[]{a, b};
    }

    static int[] searchRange2(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        if (res < 0 || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (res == 0) return new int[]{0, 0};
            else return new int[]{-1, -1};
        }
        int start = Integer.MAX_VALUE, end = -1;
        while (res >= 0) {
            if (start > res) {
                start = res;
            }
            if (end < res) {
                end = res;
            }
            if (res - 1 >= 0 && res + 1 < nums.length) {
                if (nums[res - 1] == target && nums[res + 1] == target) {

                }
            }
            nums[res] = res < nums.length - 1 && nums[res + 1] > target ? target + 1 : target - 1;
            res = Arrays.binarySearch(nums, target);
        }
        return new int[]{start, end};
    }

    static int[] searchRange1(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        if (res < 0 || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (res == 0) return new int[]{0,0};
            else return new int[]{-1, -1};
        }
        int left = Arrays.binarySearch(nums, target - 1);
        int right = Arrays.binarySearch(nums, target + 1);
        if (left == -1 && right == nums.length - 1) return new int[]{0, right};
        left = left > 0 ? left : -left - 1;
        right = right > 0 ? right : -right - 1;
        if (right - left == 2) return new int[]{res, res};
        int start = left, finish = left, leftTemp = left;
        while (leftTemp <= right) {
            if (nums[leftTemp] == target && start == left) {
                start = leftTemp;
            }
            if (nums[leftTemp] > target) {
                finish = leftTemp - 1;
                break;
            }
            leftTemp++;
        }
        return new int[]{start, finish};
    }
}
