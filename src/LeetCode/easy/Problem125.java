package LeetCode.easy;

public class Problem125 {
    //https://leetcode.com/problems/valid-palindrome/
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("  "));
        System.out.println(isPalindrome("0P"));
    }

    //https://leetcode.com/problems/valid-palindrome/solutions/2758774/java-o-n-100-faster-solution/
    //Runtime
    //2 ms
    //Beats
    //99.93%
    //Memory
    //42.4 MB
    //Beats
    //93.80%

    //https://leetcode.com/problems/valid-palindrome/solutions/2758682/java-o-n-n-solution/
    //Runtime
    //5 ms
    //Beats
    //87.80%
    //Memory
    //44.2 MB
    //Beats
    //46.72%
    static boolean isPalindrome(String s) {
//        s = s.toLowerCase();
        int diff = 'a' - 'A';
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (isValid(l)) {
                if (isValid(r)) {
                    if (isNumeric(l) && isNumeric(r) && l != r) return false;
                    if (isNumeric(l) && !isNumeric(r) || !isNumeric(l) && isNumeric(r)) return false;
                    if (isCapitalLetter(l) && isCapitalLetter(r) && l != r) return false;
                    if (isSmallLetter(l) && isSmallLetter(r) && l != r) return false;
                    if ((isCapitalLetter(l) && !isCapitalLetter(r) || !isCapitalLetter(l) && isCapitalLetter(r)) && Math.abs(l - r) != diff) return false;
                } else {
                    right--;
                    continue;
                }
            } else {
                left++;
                continue;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isValid(char c) {
        return c >= 'a' &&  c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    private static boolean isLetter(char c) {
        return c >= 'a' &&  c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private static boolean isCapitalLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isSmallLetter(char c) {
        return c >= 'a' &&  c <= 'z';
    }

    private static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }
}
