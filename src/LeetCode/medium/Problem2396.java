package LeetCode.medium;

public class Problem2396 {
    //https://leetcode.com/problems/strictly-palindromic-number/

    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(9));
        System.out.println(isStrictlyPalindromic(4));
        System.out.println(isStrictlyPalindromic(23));
    }

    //18 min
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Strictly Palindromic Number.
    //Memory Usage: 40 MB, less than 81.82% of Java online submissions for Strictly Palindromic Number.
    static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String baseRep = findBaseRep(n, i);
            if (!isPalindromic(baseRep)) return false;
        }
        return true;
    }

    private static String findBaseRep(int num, int base) {
        if (base == 2) return Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }

    private static boolean isPalindromic(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
