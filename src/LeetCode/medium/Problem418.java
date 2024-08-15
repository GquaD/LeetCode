package LeetCode.medium;

public class Problem418 {
    //https://leetcode.com/problems/sentence-screen-fitting/


    //1h nnn
    //Runtime
    //2729
    //ms
    //Beats
    //5.09%
    //Analyze Complexity
    //Memory
    //40.83
    //MB
    //Beats
    //63.53%
    public int wordsTyping(String[] s, int rows, int cols) {
        for (String str : s) {
            if (str.length() > cols) return 0;
        }
        int words = 0, r = 1, c = cols, count = 0;
        while (r <= rows) {
            int len = s[words % s.length].length();
            if (c >= len) {
                c -= len + 1;
                words++;
            } else {
                c = cols;
                r++;
            }
            if (words == s.length) {
                count++;
                words = 0;
            }
        }
        return count;
    }
}
