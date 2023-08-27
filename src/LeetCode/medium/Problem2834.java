package LeetCode.medium;

public class Problem2834 {
    //https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/
    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(36,21));
        System.out.println(minimumPossibleSum(2,3));
        System.out.println(minimumPossibleSum(3, 3));
        System.out.println(minimumPossibleSum(1, 1));
    }

    //https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/solutions/3968127/java-o-1-1-liner-math-solution/
    //10-15min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.7 MB
    //Beats
    //50%

    static long minimumPossibleSum(int n, int t) {
        return t / 2 < n ? (((long) (1 + t / 2) * (t / 2)) / 2) + ((2L * t + (long) (n - 1 - t / 2)) * (n - t / 2) / 2) : (long) (1 + n) * n / 2;
    }

    static long minimumPossibleSum1(int n, int t) {
        if (t / 2 < n) {
            long first = ((long) (1 + t / 2) * (t / 2)) / 2;
            long sec = (2L * t + (long) (n - 1 - t / 2)) * (n - t / 2) / 2;
            return first + sec;
        } else {
            return (long) (1 + n) * n / 2;
        }
    }
}
