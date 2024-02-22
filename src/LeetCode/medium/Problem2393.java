package LeetCode.medium;

public class Problem2393 {
    //https://leetcode.com/problems/count-strictly-increasing-subarrays/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-strictly-increasing-subarrays/solutions/4767579/java-o-n-100-faster/
    //10min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //56.83
    //MB
    //Beats
    //80.33%
    //of users with Java
    static long countSubarrays(int[] nums) {
        int c = 0;
        long sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                c++;
            } else {
                sum += ((1L + c) * c) / 2;
                c = 0;
            }
        }
        if (c > 0) sum += ((1L + c) * c) / 2;
        sum += nums.length;
        return sum;
    }
}
