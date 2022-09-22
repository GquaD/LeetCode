package LeetCode.easy;

public class Problem2413 {
    //https://leetcode.com/problems/smallest-even-multiple/
    public static void main(String[] args) {

    }
//1 min
    //https://leetcode.com/problems/smallest-even-multiple/discuss/2609380/Java-100-faster-1-line-solution
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Smallest Even Multiple.
//    Memory Usage: 41.1 MB, less than 44.72% of Java online submissions for Smallest Even Multiple.

    static int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else return n * 2;
    }

    static int smallestEvenMultiple2(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
