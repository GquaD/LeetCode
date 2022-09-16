package LeetCode.easy;

public class Problem724 {

    //https://leetcode.com/problems/find-pivot-index/

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[] {1,2,3}));
        System.out.println(pivotIndex(new int[] {2,1,-1}));
        System.out.println(pivotIndex(new int[] {1,-1, 2}));
        System.out.println(pivotIndex(new int[] {-1, -1, -1, -1, -1, -1}));
        System.out.println(pivotIndex(new int[] {-1, -1, -1, -1, 0, 1}));
        System.out.println(pivotIndex(new int[] {-1, -1, -1, 1, -1, -1}));
        System.out.println("///");
        System.out.println(pivotIndex(new int[] {-1, -1, 1, 1, 0, 0}));
        System.out.println(pivotIndex(new int[] {0}));

    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] sumsFromLeft = new int[nums.length];
        sumsFromLeft[0] = nums[0];
        int[] sumsFromRight = new int[nums.length];
        sumsFromRight[nums.length - 1] = nums[nums.length - 1];


        for (int i = 1; i < nums.length; i++) {
            sumsFromLeft[i] = sumsFromLeft[i - 1] + nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            sumsFromRight[i - 1] = sumsFromRight[i] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (sumsFromRight[i + 1] == 0) {
                    return i;
                } else {
                    continue;
                }
            }
            if (i == nums.length - 1) {
                if (sumsFromLeft[i - 1] == 0) {
                    return i;
                } else {
                    continue;
                }
            }
            if (sumsFromLeft[i - 1] == sumsFromRight[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
