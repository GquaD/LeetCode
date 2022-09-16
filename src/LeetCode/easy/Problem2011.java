package LeetCode.easy;

public class Problem2011 {
    //https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
    public static void main(String[] args) {

    }

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("+")) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }
}
