package LeetCode.medium;

public class Problem1400 {
    //https://leetcode.com/problems/construct-k-palindrome-strings/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/construct-k-palindrome-strings/solutions/3630491/java-simple-using-alphabet-array/
    //5-10min
    //Runtime
    //7 ms
    //Beats
    //68.64%
    //Memory
    //44.5 MB
    //Beats
    //8.18%
    static boolean canConstruct(String s, int k) {
        if (s.length() == k) return true;
        if (s.length() < k) return false;
        int alph[] = new int[26], countOdd = 0;
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        for (int i = 0; i < alph.length; i++) if (alph[i] % 2 == 1) countOdd++;
        return countOdd <= k;
    }
}
