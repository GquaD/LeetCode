package LeetCode;

public class Problem461 {
    //https://leetcode.com/problems/hamming-distance/
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(3, 1));
    }

    //Runtime: 1 ms, faster than 42.91% of Java online submissions for Hamming Distance.
    //Memory Usage: 40.8 MB, less than 67.02% of Java online submissions for Hamming Distance.
    static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return count1sInBinaryOf(xor);
    }

    static int count1sInBinaryOf(int n) {
        int count = 0;
        while (n > 0) {
            count += n % 2 == 0 ? 0 : 1;
            n /= 2;
        }
        return count;
    }
}
