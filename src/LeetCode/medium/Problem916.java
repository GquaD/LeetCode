package LeetCode.medium;
import java.util.*;

public class Problem916 {
    //https://leetcode.com/problems/word-subsets/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/word-subsets/solutions/4461953/java-o-n-k-solution/
    //30min
    //Runtime
    //20 ms
    //Beats
    //15.63%
    //Memory
    //55.9 MB
    //Beats
    //6.25%
    static List<String> wordSubsets(String[] words1, String[] words2) {
        int len1 = words1.length, len2 = words2.length;
        int[][] w1 = new int[len1][26], w2 = new int[len2][26];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < words1[i].length(); j++) {
                w1[i][words1[i].charAt(j) - 'a']++;
            }
        }

        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < words2[i].length(); j++) {
                w2[i][words2[i].charAt(j) - 'a']++;
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            boolean uni = true;
            for (int j = 0; j < len2; j++) {
                for (int k = 0; k < 26; k++) {
                    if (w1[i][k] < w2[j][k]) {
                        uni = false;
                        break;
                    }
                }
                if (!uni) break;
            }
            if (uni) list.add(words1[i]);
        }
        return list;
    }
}
