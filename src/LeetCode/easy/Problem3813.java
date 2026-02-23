package LeetCode.easy;

public class Problem3813 {
    //5min

    //https://leetcode.com/problems/vowel-consonant-score/
    //Runtime
    //1
    //ms
    //Beats
    //99.82%
    //Analyze Complexity
    //Memory
    //43.79
    //MB
    //Beats
    //41.97%
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            if (isVowel(l)) v++;
            else if (l >= 'b' && l <= 'z')
                c++;
        }

        return c > 0 ? v / c : 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
