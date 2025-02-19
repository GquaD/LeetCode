package LeetCode.easy;

public class Problem3442 {
    //https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/solutions/6442117/java-on-solution-by-tbekpro-mndt/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.08
    //MB
    //Beats
    //98.62%
    public int maxDifference(String s) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        int max = 0, min = 100;
        for (int i = 0; i < 26; i++) {
            if (alph[i] != 0) {
                if (alph[i] % 2 == 0) {
                    min = Math.min(min, alph[i]);
                } else {
                    max = Math.max(max, alph[i]);
                }
            }
        }
        return max - min;
    }
}
