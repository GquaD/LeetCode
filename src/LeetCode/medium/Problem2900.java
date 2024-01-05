package LeetCode.medium;
import java.util.*;

public class Problem2900 {
    //https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/solutions/4512126/java-o-n-greedy/
    //5-10min
    //Runtime
    //1 ms
    //Beats
    //98.31%
    //Memory
    //45.3 MB
    //Beats
    //5.8%
    static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int prev = groups[0];

        for (int i = 1; i < n; i++) {
            if (prev != groups[i]) {
                list.add(words[i]);
                prev = groups[i];
            }
        }
        return list;
    }
}
