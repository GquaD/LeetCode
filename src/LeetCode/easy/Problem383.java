package LeetCode.easy;

public class Problem383 {
    //https://leetcode.com/problems/ransom-note/
    public static void main(String[] args) {

    }

    //10 min
    //https://leetcode.com/problems/ransom-note/solutions/2861997/java-2ms-99-time-95-memory-explained/
    //Runtime
    //2 ms
    //Beats
    //99.39%
    //Memory
    //42.5 MB
    //Beats
    //94.76%
    public boolean canConstruct(String r, String m) {
        int[] alph = new int[26];
        for (int i = 0; i < m.length(); i++) {
            alph[m.charAt(i) - 'a']++;
        }
        for (int i = 0; i < r.length(); i++) {
            alph[r.charAt(i) - 'a']--;
        }
        for (int n : alph) {
            if (n < 0) return false;
        }
        return true;
    }
}
