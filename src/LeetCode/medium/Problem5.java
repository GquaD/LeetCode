package LeetCode.medium;

public class Problem5 {
    //https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bbcd"));
        System.out.println(longestPalindrome("cbbd"));
    }


    //Runtime
    //21
    //ms
    //Beats
    //34.92%
    //Memory
    //47.16
    //MB
    //Beats
    //13.47%
    public String longestPalindrome5(String s) {
        int max = 1;
        String maxs = "" + s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            String t = "" + c;

            if (c == s.charAt(i + 1)) {
                int idx = 0;
                while (i - idx >= 0 && i + idx + 1 < s.length()) {
                    if (s.charAt(i - idx) != s.charAt(i + idx + 1)) break;
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
                    if (s.charAt(i - idx) != s.charAt(i + idx)) break;
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


    //Runtime
    //1609
    //ms
    //Beats
    //9.07%
    //Memory
    //46.95
    //MB
    //Beats
    //22.12%

    public String longestPalindrome3(String s) {
        if (s.length() == 1)
            return s;

        String max = "";

        for (int i = 0; i < s.length(); i++) {
            int d = 0;
            while (i - d >= 0 && i + d < s.length()) {
                if (isPalindrome2(i - d, i + d, s)) {
                    if (i + d - (i - d) + 1 > max.length()) {
                        max = s.substring(i - d, i + d + 1);
                    }
                } else break;

                d++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int d = 0;
                while (i - d >= 0 && i + 1 + d < s.length()) {
                    if (isPalindrome2(i - d, i + 1 + d, s)) {
                        if (i + 1 + d - (i - d) + 1 > max.length()) {
                            max = s.substring(i - d, i + 1 + d + 1);
                        }
                    } else break;

                    d++;
                }
            }
        }

        return max;
    }

    private boolean isPalindrome2(int start, int end, String s) {
        int mid = (end - start) / 2;
        for (int i = 0; i <= mid; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }

        return true;
    }


    //Runtime
    //1900
    //ms
    //Beats
    //6.57%
    //Memory
    //46.64
    //MB
    //Beats
    //35.13%
    public String longestPalindrome2(String s) {
        String max = s.charAt(0) + "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) {
                    if (j - i + 1 > max.length()) {
                        max = s.substring(i, j + 1);
                    }
                }
            }
        }

        return max;
    }

    private boolean isPalindrome(int start, int end, String s) {
        int mid = (end - start) / 2;
        for (int i = 0; i <= mid; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }

        return true;
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
