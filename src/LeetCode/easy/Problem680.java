package LeetCode.easy;

public class Problem680 {
    //https://leetcode.com/problems/valid-palindrome-ii/description/
    public static void main(String[] args) {
        System.out.println(validPalindrome("deddde"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
    }

    //5min
    //Runtime
    //7
    //ms
    //Beats
    //11.72%
    //Analyze Complexity
    //Memory
    //45.74
    //MB
    //Beats
    //15.84%
    //public boolean validPalindrome(String s) {
    //        int idx = -1, len = s.length();
    //        for (int i = 0; i < len / 2; i++) {
    //            if (s.charAt(i) != s.charAt(len - i - 1)) {
    //                idx = i;
    //                break;
    //            }
    //        }
    //        if (idx == -1) return true;
    //
    //        return isPalindrome(s.substring(0, idx) + s.substring(idx + 1)) || isPalindrome(s.substring(0, len - idx - 1) + s.substring(len - idx));
    //    }
    //
    //    private boolean isPalindrome(String s) {
    //        for (int i = 0; i < s.length() / 2; i++) {
    //            if (s.charAt(i) != s.charAt(s.length() - i - 1))
    //                return false;
    //        }
    //        return true;
    //    }

    //https://leetcode.com/problems/valid-palindrome-ii/solutions/4358133/java-o-3n-o-n-solution/
    //10min
    //Runtime
    //7 ms
    //Beats
    //20.22%
    //Memory
    //44.5 MB
    //Beats
    //26.5%
    static boolean validPalindrome(String s) {
        int len = s.length(), l = 0, r = len - 1;
        boolean isPalindrome = true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                isPalindrome = false;
                break;
            }
            l++;
            r--;
        }
        if (isPalindrome) return true;

        String s1 = s.substring(0, l) + s.substring(l + 1);
        String s2 = s.substring(0, r) + s.substring(r + 1);
        l = 0;
        r = s1.length() - 1;
        while (l < r) {
            if (s1.charAt(l) != s1.charAt(r)) break;
            l++;
            r--;
        }

        if (l >= r) return true;

        l = 0;
        r = s2.length() - 1;
        while (l < r) {
            if (s2.charAt(l) != s2.charAt(r)) break;
            l++;
            r--;
        }
        return l >= r;
    }
}
