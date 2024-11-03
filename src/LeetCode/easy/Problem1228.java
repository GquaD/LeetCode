package LeetCode.easy;

public class Problem1228 {
    //https://leetcode.com/problems/missing-number-in-arithmetic-progression
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/missing-number-in-arithmetic-progression/solutions/6002231/java-o-n-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //13.64%
    //Analyze Complexity
    //Memory
    //42.74
    //MB
    //Beats
    //7.76%
    public int missingNumber(int[] arr) {
        int min = Math.abs(arr[0] - arr[1]);
        for (int i = 1; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }
        if (min == 0) return arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) != min) {
                return (arr[i] + arr[i + 1]) / 2;
            }
        }
        return 0;
    }
}
