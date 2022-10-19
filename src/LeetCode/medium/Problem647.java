package LeetCode.medium;

public class Problem647 {
    //https://leetcode.com/problems/palindromic-substrings/

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("a"));
        System.out.println(countSubstrings("starab"));
        System.out.println(countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));//64
    }

    //Runtime
    //920 ms
    //Beats
    //5.62%
    //Memory
    //117.8 MB
    //Beats
    //6.47%
    static int countSubstrings(String s) {
        int count = s.length();
        if (s.length() == 1) return count;
        for (int pointer = 1; pointer < s.length(); pointer++) {
            int l = pointer - 1, r = pointer + 1;
            while (l >= 0 && r <= s.length()) {
                if (isPalindromic(s.substring(l, r))) {
                    count++;
                }
                r++;
                if (r <= s.length() && isPalindromic(s.substring(l, r))) {
                    count++;
                }
                l--;
            }
        }
        return count;
    }

    //Runtime
    //875 ms
    //Beats
    //6.11%
    //Memory
    //117.3 MB
    //Beats
    //8.6%
    static int countSubstrings1(String s) {
        int count = s.length();
        if (s.length() == 1) return count;
        if (isPalindromic(s)) count++;
        for (int i = 2; i < s.length(); i++) {
            int a = 0, b = i;
            while (b <= s.length()) {
                if (isPalindromic(s.substring(a++, b++))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
