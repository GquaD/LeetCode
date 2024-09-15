package LeetCode.easy;

public class Problem3289 {
    //https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/solutions/5790161/java-100-faster-100-memory/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.34
    //MB
    //Beats
    //100.00%
    static int[] getSneakyNumbers(int[] nums) {
        int[] unique = new int[nums.length - 2], res = new int[2];
        int c = 0;
        for (int n : nums) {
            if (++unique[n] > 1) {
                res[c++] = n;
            }
        }
        return res;
    }
}
