package LeetCode.easy;

public class Problem2733 {
    //https://leetcode.com/problems/neither-minimum-nor-maximum/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/neither-minimum-nor-maximum/solutions/3693928/java-o-n/
    //5 min
    //Runtime
    //8 ms
    //Beats
    //91.99%
    //Memory
    //44 MB
    //Beats
    //42.70%
    static int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;
        int min = nums[0], max = min, target = -1;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        for (int n : nums) {
            if (n < max && n > min) {
                target = n;
                break;
            }
        }
        return target;
    }

    //5 min
    //Runtime
    //8 ms
    //Beats
    //91.99%
    //Memory
    //43.6 MB
    //Beats
    //91.29%
    static int findNonMinOrMax1(int[] nums) {
        if (nums.length < 3) return -1;
        int min = nums[0], max = min, target = -1;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        for (int n : nums) if (n < max && n > min) target = n;
        return target;
    }
}
