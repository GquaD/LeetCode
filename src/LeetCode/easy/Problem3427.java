package LeetCode.easy;

public class Problem3427 {
    //https://leetcode.com/problems/sum-of-variable-length-subarrays/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sum-of-variable-length-subarrays/solutions/6303329/java-prefix-sum-100-time-100-memory-solu-jnku/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.97
    //MB
    //Beats
    //100.00%
    public int subarraySum(int[] nums) {
        int len = nums.length, pref[] = new int[len], prev = 0;
        for (int i = 0; i < len; i++) {
            pref[i] = prev + nums[i];
            prev = pref[i];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            int s = Math.max(0, i - nums[i]);
            res += pref[i] - pref[s] + nums[s];
        }
        return res;
    }
}
