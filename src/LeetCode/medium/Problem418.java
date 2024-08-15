package LeetCode.medium;

public class Problem418 {
    //https://leetcode.com/problems/sentence-screen-fitting/


    //1h nnn
    //Runtime
    //2656
    //ms
    //Beats
    //5.09%
    //Analyze Complexity
    //Memory
    //40.92
    //MB
    //Beats
    //47.45%
    public int wordsTyping(String[] s, int rows, int cols) {
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
