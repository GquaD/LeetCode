package LeetCode.medium;

public class Problem1638 {
    //https://leetcode.com/problems/count-substrings-that-differ-by-one-character
    public static void main(String[] args) {
        System.out.println(countSubstrings("aba", "baba"));
    }


    //Lee's solution
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //80%
    static int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            res += helper(s, t, i, 0);
        for (int i = 1; i < t.length(); i++)
            res += helper(s, t, 0, i);
        return res;
    }

    private static int helper(String s, String t, int i, int j) {
        int res = 0, pre = 0, curr = 0;
        for (int n = s.length(), m = t.length(); i < n && j < m; ++i, ++j) {
            curr++;
            if (s.charAt(i) != t.charAt(j)) {
                pre = curr;
                curr = 0;
            }
            res += pre;
        }
        return res;
    }


}
