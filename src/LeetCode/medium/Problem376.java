package LeetCode.medium;

public class Problem376 {
    //https://leetcode.com/problems/wiggle-subsequence/
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,1,7,4,9,2,5}));
        System.out.println(wiggleMaxLength(new int[]{5,5,5,5,5}));
        System.out.println(wiggleMaxLength(new int[]{0,0,0}));
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    //nnnn
    //1hour
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.5 MB
    //Beats
    //19.54%
    static int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int countNotWiggle = nums.length;
        Boolean positive = null;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1] - nums[i];
            if (temp == 0) {
                countNotWiggle--;
            } else if (positive == null) {
                positive = temp > 0;
            } else if ((temp > 0 && positive) || (temp < 0 && !positive)) {
                countNotWiggle--;
            } else {
                positive = !positive;
            }

        }
        return countNotWiggle;
    }


    static int wiggleMaxLength2(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        int countNotWiggle = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            nums[i] = nums[i] - prev;
            prev = t;
        }
        Boolean prevPos = null;
        for (int i = 1; i < nums.length; i++) {
            boolean currPos = nums[i] > 0;
            if (prevPos == null || nums[i - 1] == 0) prevPos = !currPos;
            if (nums[i] == 0 || prevPos == currPos) countNotWiggle++;
            prevPos = currPos;
        }
        return nums.length - countNotWiggle;
    }

    static int wiggleMaxLength1(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        int countNotWiggle = nums[0] == nums[1] ? 1 : 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            nums[i] = nums[i] - prev;
            prev = t;
        }
        boolean prevPos = countNotWiggle > 0 ? nums[2] >= 0 : nums[1] >= 0;
        for (int i = 2; i < nums.length; i++) {
            boolean currPos = nums[i] >= 0;
            if (prevPos == currPos) countNotWiggle++;
            prevPos = currPos;
        }
        return nums.length - countNotWiggle;
    }
}
