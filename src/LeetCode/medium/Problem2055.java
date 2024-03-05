package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2055 {
    //https://leetcode.com/problems/plates-between-candles/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("||*", new int[][]{{2, 2}})));
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
    }

    //https://leetcode.com/problems/plates-between-candles/solutions/4827335/java-o-nlogn-solution/
    //30min
    //Runtime
    //69
    //ms
    //Beats
    //23.89%
    //of users with Java
    //Memory
    //77.24
    //MB
    //Beats
    //98.32%
    //of users with Java
    static int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '|') candles.add(i);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            int l = Collections.binarySearch(candles, a), r = Collections.binarySearch(candles, b);
            if (l < 0) l = Math.min(-l - 1, candles.size() - 1);
            if (r < 0) r = Math.min(-r - 2, candles.size() - 1);
            res[i] = Math.max(0, candles.get(r) - candles.get(l) - r + l);
        }
        return res;
    }
}
