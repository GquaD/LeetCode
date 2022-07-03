package LeetCode;

public class Problem1486 {
    //https://leetcode.com/problems/xor-operation-in-an-array/


    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(0, 0));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for XOR Operation in an Array.
    //Memory Usage: 38.9 MB, less than 95.56% of Java online submissions for XOR Operation in an Array.
    public static int xorOperation(int n, int start) {
        int xor = start;
        for (int i = 1; i < n; i++) {
            int temp = start + 2 * i;
            xor ^= temp;
        }
        return xor;
    }
}
