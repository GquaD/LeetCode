package LeetCode.medium;

import java.util.Arrays;

public class Problem198 {
    //https://leetcode.com/problems/house-robber/
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2}));
        System.out.println(rob(new int[]{2,1}));
        System.out.println(rob(new int[]{1,3,1}));
        System.out.println(rob(new int[]{2,4,8,9,9,3}));
        System.out.println(rob(new int[]{1,3,1,3,100,1}));
        System.out.println(rob(new int[]{1,3,1,3,100}));
        System.out.println(rob(new int[]{1,1,1,1}));
        System.out.println(rob(new int[]{2,1,1,1}));
        System.out.println(rob(new int[]{1,2,1,1}));
        System.out.println(rob(new int[]{1,1,2,1}));
        System.out.println(rob(new int[]{1,1,1,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1,9}));
        System.out.println(rob(new int[]{1}));
        System.out.println(rob(new int[]{1,2}));
        System.out.println(rob(new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/house-robber/solutions/2911947/java-0ms-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.6 MB
    //Beats
    //90.95%
    static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return nums[nums.length - 1];
    }

    static int rob2(int[] nums) {
        int[] sums = new int[nums.length];
        if (nums.length < 5) return robHelp(nums);
        for (int i = 0; i < 2; i++) {
            int[] temp = new int[nums.length];
            int count = 0;
            for (int j = i; j < temp.length; j++) {
                temp[count++] = nums[j];
            }
            for (int j = 0; j < i; j++) {
                temp[count++] = nums[j];
            }
            sums[i] = robHelp(temp);
        }
        return Arrays.stream(sums).max().getAsInt();
    }

    static int rob1(int[] nums) {
        if (nums.length < 4) {
            return robHelp(nums);
        }
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        int[] nums3 = new int[nums.length - 2];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i + 1];
            nums2[i] = nums[i];
        }

        for (int i = 0; i < nums3.length; i++) {
            nums3[i] = nums[i + 1];
        }

        return Math.max(Math.max(robHelp(nums), robHelp(nums3)), Math.max(robHelp(nums1), robHelp(nums2)));
    }

    //46th /68 failed
    static int robHelp(int[] nums) {
        if (nums.length < 4) {
            return findBestWhenLessThanFour(nums, 0, nums.length - 1);
        }
        int start = 0, end = 3, sum = 0;
        while (start < nums.length && end < nums.length) {
            int s1 = nums[start] + nums[start + 2]; //1 + 3
            int s2 = nums[start + 1] + nums[start + 3]; // 2 + 4
            int s3 = nums[start] + nums[start + 3]; //1 + 4
            if (s1 >= s2 && s1 >= s3) {
                sum += s1;
                start += 4;
                end += 4;
            } else if (s2 > s1 && s2 >= s3) {
                sum += s2;
                start += 5;
                end += 5;
            } else if (s3 > s1 && s3 >= s2) {
                sum += s3;
                start += 5;
                end += 5;
            }
        }
        if (start < nums.length) {
            sum += findBestWhenLessThanFour(nums, start, nums.length - 1);
        }

        return sum;
    }

    private static int findBestWhenLessThanFour(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        } else {
            return Math.max(nums[start] + nums[end], nums[start + 1]);
        }
    }
}
