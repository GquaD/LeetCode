package LeetCode.easy;

public class Problem908 {
    //https://leetcode.com/problems/smallest-range-i/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/smallest-range-i/solutions/2755092/java-o-n-solution/
    //10 mins
    //Runtime
    //8 ms
    //Beats
    //38.14%
    //Memory
    //49.5 MB
    //Beats
    //33.61%
    static int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }
        int diff = max - min;
        if (diff <= k + k) {
            return 0;
        } else {
            return diff - (k + k);
        }
    }
}
