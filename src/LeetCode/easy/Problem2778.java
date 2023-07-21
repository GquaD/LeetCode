package LeetCode.easy;

public class Problem2778 {
    //https://leetcode.com/problems/sum-of-squares-of-special-elements/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sum-of-squares-of-special-elements/solutions/3797987/java-3-lines-o-n/
    //2-5 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //43.4 MB
    //Beats
    //53.5%
    static int sumOfSquares(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) if (nums.length % (i + 1) == 0) sum += nums[i] * nums[i];
        return sum;
    }
}
