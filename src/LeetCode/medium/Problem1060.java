package LeetCode.medium;

public class Problem1060 {
    //https://leetcode.com/problems/missing-element-in-sorted-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/missing-element-in-sorted-array/solutions/5091378/java-o-n-solution/
    //5-10min
    //Runtime
    //2
    //ms
    //Beats
    //24.56%
    //of users with Java
    //Memory
    //49.30
    //MB
    //Beats
    //46.59%
    //of users with Java
    static int missingElement(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i], prev = nums[i - 1], diff = cur - prev - 1;
            if (diff < k) k -= diff;
            else return prev + k;
        }
        return nums[nums.length - 1] + k;
    }
}
