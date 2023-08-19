package LeetCode.medium;

public class Problem2825 {
    //https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
        System.out.println(canMakeSubsequence("zc", "ad"));
        System.out.println(canMakeSubsequence("ab", "d"));
        System.out.println(canMakeSubsequence("ab", "dd"));
    }

    //https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/solutions/3932693/java-o-n-100-faster-solution/
    //10min
    //Runtime
    //6 ms
    //Beats
    //100%
    //Memory
    //44.6 MB
    //Beats
    //100%
    static boolean canMakeSubsequence(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        int i = 0, l = 0;
        while (i < str1.length() && l < str2.length()) {
            int a = str1.charAt(i) - 'a', b = str2.charAt(l) - 'a', cyclic = (a + 1) % 26;
            if (a == b || cyclic == b) {
                i++;
                l++;
            } else {
                i++;
            }
        }
        return l == str2.length();
    }
}
