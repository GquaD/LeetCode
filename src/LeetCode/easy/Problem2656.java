package LeetCode.easy;

public class Problem2656 {
    //https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/solutions/3491477/java-o-n-k-solution/
    //2 min
    //Runtime
    //3 ms
    //Beats
    //97.86%
    //Memory
    //42.8 MB
    //Beats
    //62.30%
    static int maximizeSum(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) if (max < nums[i]) max = nums[i];
        for (int i = 0; i < k; i++) sum += max++;
        return sum;
    }
}
