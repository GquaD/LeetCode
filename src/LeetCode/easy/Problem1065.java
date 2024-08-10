package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1065 {
    //https://leetcode.com/problems/index-pairs-of-a-string


    //https://leetcode.com/problems/index-pairs-of-a-string/solutions/5616926/java-straightforward-solution/
    //5-10min
    //Runtime
    //4
    //ms
    //Beats
    //69.33%
    //Analyze Complexity
    //Memory
    //44.96
    //MB
    //Beats
    //33.33%
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String w: words) {
            for (int i = 0; i <= text.length() - w.length(); i++) {
                if (text.substring(i, i + w.length()).equals(w)) {
                    list.add(new int[]{i, i + w.length() - 1});
                }
            }
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
