package LeetCode.easy;

public class Problem3392 {
    //https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/solutions/6177555/java-100-faster-solution-by-tbekpro-jivo/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.30
    //MB
    //Beats
    //100.00%
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) if (nums[i - 1] % 2 == 0 && nums[i - 2] + nums[i] == nums[i - 1] / 2) count++;
        return count;
    }
}
