package LeetCode.hard;

public class Problem1639 {
    //https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/
    public static void main(String[] args) {
        System.out.println(numWays(new String[]{"acca", "bbbb", "caca"}, "aba"));
    }

    //nnnn
    //Runtime
    //80 ms
    //Beats
    //92.35%
    //Memory
    //49 MB
    //Beats
    //89.28%
    static int numWays(String[] words, String target) {
        int n = target.length(), w = words[0].length();
        long mod = 1_000_000_007L, res[] = new long[n + 1];
        res[0] = 1;
        for (int i = 0; i < w; i++) {
            int[] alph = new int[26];
            for (String word : words) alph[word.charAt(i) - 'a']++;
            for (int j = n - 1; j >= 0; j--)
                res[j + 1] += res[j] * alph[target.charAt(j) - 'a'] % mod;
        }
        return (int)(res[n] % mod);
    }
}
