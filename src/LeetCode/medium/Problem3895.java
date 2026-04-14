package LeetCode.medium;

public class Problem3895 {
    //2min

    //Runtime
    //4
    //ms
    //Beats
    //98.33%
    //Memory
    //47.02
    //MB
    //Beats
    //45.83%
    //https://leetcode.com/problems/count-digit-appearances/solutions/7906185/java-elegant-solution-by-tbekpro-wvrv/
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for (int n: nums) {
            while (n > 0) {
                if (n % 10 == digit) count++;
                n /= 10;
            }
        }
        return count;
    }
}
