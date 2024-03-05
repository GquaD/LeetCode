package LeetCode.hard;
import java.util.*;

public class Problem2781 {
    //https://leetcode.com/problems/length-of-the-longest-valid-substring/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //125
    //ms
    //Beats
    //79.50%
    //of users with Java
    //Memory
    //61.99
    //MB
    //Beats
    //72.75%
    //of users with Java
    static int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet();
        int max = 0, limit = word.length(), maxWord = 0;
        for(String s : forbidden) {
            set.add(s);
            max = Math.max(max, s.length());
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= limit && j - i <= max; j++) {
                String t = word.substring(i, j);
                if (set.contains(t)) {
                    limit = j - 1;
                    break;
                }
            }
            maxWord = Math.max(maxWord, limit - i);
        }
        return maxWord;
    }
}
