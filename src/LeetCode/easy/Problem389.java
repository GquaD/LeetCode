package LeetCode.easy;

public class Problem389 {
    //https://leetcode.com/problems/find-the-difference/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-difference/solutions/2868766/java-solution-using-array/
    //Runtime
    //10 ms
    //Beats
    //24.49%
    //Memory
    //42.5 MB
    //Beats
    //36.85%
    static char findTheDifference(String s, String t) {
        short[] alph = new short[26];
        for (char c : s.toCharArray()) {
            alph[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alph[c - 'a']--;
        }
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != 0) return (char)(i + 'a');
        }
        return 'a';
    }
}
