package LeetCode.easy;

public class Problem3120 {
    //https://leetcode.com/problems/count-the-number-of-special-characters-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-the-number-of-special-characters-i/solutions/5391503/java-100-fastest-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.40
    //MB
    //Beats
    //37.44%
    int numberOfSpecialChars(String word) {
        int[] low = new int[26], up = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                low[c - 'a']++;
            } else {
                up[c - 'A']++;
            }
        }
        int n = 0;
        for (int i = 0; i < 26; i++) {
            if (low[i] > 0 && up[i] > 0) n++;
        }
        return n;
    }
}
