package LeetCode.easy;

public class Problem762 {
    //https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
    public static void main(String[] args) {

    }

    //Runtime: 12 ms, faster than 76.74% of Java online submissions for Prime Number of Set Bits in Binary Representation.
    //Memory Usage: 40.7 MB, less than 84.22% of Java online submissions for Prime Number of Set Bits in Binary Representation.
    static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int numOf1s = Integer.bitCount(i);
            if (isPrime(numOf1s)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        int grow = 2;
        int sqrt = (int) Math.sqrt(n);
        while (grow <= sqrt) {
            if (n % grow++ == 0) {
                return false;
            }
        }
        return true;
    }
}
