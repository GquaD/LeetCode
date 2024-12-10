package LeetCode.easy;

public class Problem3379 {
    //https://leetcode.com/problems/transformed-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/transformed-array/solutions/6132785/java-o-n-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //99.87%
    //Analyze Complexity
    //Memory
    //44.97
    //MB
    //Beats
    //75.08%
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                res[i] = nums[(i + a) % nums.length];
            } else if (a < 0) {
                int abs = Math.abs(a) % nums.length;
                int idx = abs > i ? nums.length + i - abs : i - abs;
                res[i] = nums[idx];
            } else {
                res[i] = nums[i];
            }
        }
        return res;
    }
}
