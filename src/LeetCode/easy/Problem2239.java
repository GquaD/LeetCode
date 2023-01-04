package LeetCode.easy;

public class Problem2239 {
    //https://leetcode.com/problems/find-closest-number-to-zero/
    public static void main(String[] args) {

    }

    //5-10 min for both
    //https://leetcode.com/problems/find-closest-number-to-zero/solutions/2996124/java-3-ms-solution/
    //Runtime
    //3 ms
    //Beats
    //66.48%
    //Memory
    //51.4 MB
    //Beats
    //53.79%
    static int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (min + n == 0) {
                min = min > 0 ? min : n;
            } else if (Math.abs(min) > Math.abs(n)) {
                min = n;
            }
        }
        return min;
    }

    //Runtime
    //4 ms
    //Beats
    //55.59%
    //Memory
    //51.5 MB
    //Beats
    //53.79%

    static int findClosestNumber1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (Math.abs(min) > Math.abs(n)) {
                min = n;
            } else if (min + n == 0) {
                min = min > 0 ? min : n;
            }
        }
        return min;
    }
}
