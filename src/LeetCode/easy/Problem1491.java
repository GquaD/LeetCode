package LeetCode.easy;

public class Problem1491 {
    //https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/solutions/2913671/java-100-faster-solution/
    //5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.9 MB
    //Beats
    //87.56%
    static double average(int[] salary) {
        int sum = 0, min = Integer.MAX_VALUE, max = 0, count = 0;
        for (int n : salary) {
            sum += n;
            if (max < n) {
                max = n;
            }
            if (min > n) {
                min = n;
            }
            count++;
        }
        return ((sum - max - min) * 1.0) / (count - 2);
    }
}
