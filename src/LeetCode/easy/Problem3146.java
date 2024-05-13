package LeetCode.easy;

public class Problem3146 {
    //https://leetcode.com/problems/permutation-difference-between-two-strings/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/permutation-difference-between-two-strings/solutions/5151991/java-100-faster/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.90
    //MB
    //Beats
    //66.67%
    //of users with Java
    static int findPermutationDifference(String s, String t) {
        int[] idxs = new int[26], idxt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            idxs[s.charAt(i) - 'a'] = i;
            idxt[t.charAt(i) - 'a'] = i;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(idxs[i] - idxt[i]);
        }
        return sum;
    }
}
