package LeetCode.medium;

public class Problem1968 {
    //https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/solutions/4088675/java-91-faster-solution/
    //15min
    //Runtime
    //4 ms
    //Beats
    //90.77%
    //Memory
    //60.2 MB
    //Beats
    //96.67%
    static int[] rearrangeArray(int[] nums) {
        while (!isCorrect(nums)) {
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] == (nums[i - 1] + nums[i + 1]) / 2.0) {
                    int t = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = t;
                }
            }
        }
        return nums;
    }

    private static boolean isCorrect(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) / 2.0) {
                return false;
            }
        }
        return true;
    }


}
