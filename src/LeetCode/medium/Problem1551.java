package LeetCode.medium;

public class Problem1551 {
    //https://leetcode.com/problems/minimum-operations-to-make-array-equal/
    public static void main(String[] args) {
        System.out.println(minOperations(6));
        System.out.println(minOperations(3));
    }
    //Runtime: 1 ms, faster than 88.09% of Java online submissions for Minimum Operations to Make Array Equal.
    //Memory Usage: 41.6 MB, less than 26.59% of Java online submissions for Minimum Operations to Make Array Equal.
    static int minOperations(int n) {
        //1
        int maxVal = (n - 1) * 2 + 1;
        int sum = 0;
        //n is center
        while (maxVal >= n) {
            sum += maxVal - n;
            maxVal -= 2;
        }
        return sum;
    }
}
