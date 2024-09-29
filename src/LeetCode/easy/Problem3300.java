package LeetCode.easy;

public class Problem3300 {
    //https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/solutions/5847853/java-100-time-100-memory-solution/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.30
    //MB
    //Beats
    //100.00%
    int minElement(int[] nums) {
        int min = 40, sum = 0;
        for (int n : nums) {
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            min = Math.min(sum, min);
            sum = 0;
        }
        return min;
    }
}
