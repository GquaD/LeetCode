package LeetCode.medium;

public class Problem5 {
    //https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bbcd"));
        System.out.println(longestPalindrome("cbbd"));
    }



    //Runtime
    //23
    //ms
    //Beats
    //32.39%
    //Memory
    //47.19
    //MB
    //Beats

    public String longestPalindrome4(String s) {

        int max = 1;
        String maxs = "" + s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            int len = 1;
            String t = "" + c;

            if (c == s.charAt(i + 1)) {
                len = 0;
                int idx = 0;
                while (i - idx >= 0 && i + idx + 1 < s.length()) {
                    if (s.charAt(i - idx) == s.charAt(i + idx + 1)) {
                        len += 2;
                    } else {
                        break;
                    }
                    idx++;
                }
                t = s.substring(i - idx + 1, i + idx + 1);
            }
            if (max < t.length()) {
                max = t.length();
                maxs = t;
            }
            if (i - 1 >= 0) {
                int idx = 1;
                while (i - idx >= 0 && i + idx < s.length()) {
                    if (s.charAt(i - idx) == s.charAt(i + idx)) {
                        len += 2;
                    } else {
                        break;
                    }
                    idx++;
                }
                t = s.substring(i - idx + 1, i + idx);
            }

            if (max < t.length()) {
                max = t.length();
                maxs = t;
            }
        }

        return maxs;
    }
    //todo
    //30 mins
    //Runtime: 1454 ms, faster than 5.00% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 42.9 MB, less than 67.77% of Java online submissions for Longest Palindromic Substring.
    static String longestPalindrome(String s) {
        String palindrome = s.charAt(0) + "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String candidate = s.substring(i, j);
                if (isPalindromic(candidate) && candidate.length() > palindrome.length()) {
                    palindrome = candidate;
                }
            }
        }
        return palindrome;
    }


    private static boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static String longestPalindrome1(String s) {
        int start = 0, end = s.length();
        while (start != end) {
            String candidate = s.substring(start, end);
            if (isPalindromic(candidate)) {
                return candidate;
            }
            candidate = s.substring(start + 1, end);
            if (isPalindromic(candidate)) {
                return candidate;
            }
            candidate = s.substring(start, end - 1);
            if (isPalindromic(candidate)) {
                return candidate;
            }
            start++;
            end--;
        }
        return s.charAt(0) + "";
    }
}
