package LeetCode.easy;

public class Problem2169 {
    //https://leetcode.com/problems/count-operations-to-obtain-zero/
    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
        System.out.println(countOperations(10, 10));
    }

    //Runtime: 2 ms, faster than 81.12% of Java online submissions for Count Operations to Obtain Zero.
    //Memory Usage: 40.7 MB, less than 69.52% of Java online submissions for Count Operations to Obtain Zero.
    static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }
}
