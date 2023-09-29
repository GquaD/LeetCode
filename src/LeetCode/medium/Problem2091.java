package LeetCode.medium;

public class Problem2091 {
    //https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
    public static void main(String[] args) {
        System.out.println(minimumDeletions(new int[]{-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28}));
        System.out.println(minimumDeletions(new int[]{3,4,2}));
        System.out.println(minimumDeletions(new int[]{1}));
        System.out.println(minimumDeletions(new int[]{0,1}));
        System.out.println(minimumDeletions(new int[]{0,1,2}));
        System.out.println(minimumDeletions(new int[]{3,1,2}));
        System.out.println(minimumDeletions(new int[]{0,1,8,-2,-3,-4,19,5}));
        System.out.println(minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
        System.out.println(minimumDeletions(new int[]{2,1,7,5,4,10,8,6}));
        System.out.println(minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));
    }

    //https://leetcode.com/problems/removing-minimum-and-maximum-from-array/solutions/4105495/java-o-n-100-faster-simple-logic/
    //35min
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //59.8 MB
    //Beats
    //24.27%
    static int minimumDeletions(int[] nums) {
        if (nums.length == 1) return 1;
        int minIdx = 0, maxIdx = 0, min = nums[0], max = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            } else if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        int minDistRight = nums.length - minIdx++, maxDistRight = nums.length - maxIdx++;
        int one = Math.max(minIdx, maxIdx), two = Math.max(minDistRight, maxDistRight);
        int three = minIdx + maxDistRight, four = maxIdx + minDistRight;
        return Math.min(Math.min(one, two), Math.min(three, four));
    }

    //Wrong Answer
    //53 / 62 testcases passed
    static int minimumDeletions1(int[] nums) {
        if (nums.length == 1) return 1;
        int minIdx = 0, maxIdx = 0, min = nums[0], max = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            } else if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        int minDistRight = nums.length - minIdx++, maxDistRight = nums.length - maxIdx++;
        if (minIdx <= minDistRight) {
//            return maxIdx <= maxDistRight ? minIdx + Math.abs(maxIdx - minIdx) : minIdx + maxDistRight;
            return maxIdx < maxDistRight ? Math.max(minIdx, maxIdx) : minIdx + maxDistRight;
        } else {
//            return maxIdx <= maxDistRight ? minDistRight + maxIdx : minDistRight + Math.abs(maxDistRight - minDistRight);
            return maxIdx < maxDistRight ? minDistRight + maxIdx : Math.max(minDistRight, maxDistRight);
        }
    }
}
