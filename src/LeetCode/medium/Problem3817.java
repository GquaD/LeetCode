package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3817 {

    //5-10min
    //Runtime
    //314
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //63.76
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/good-indices-in-a-digit-string/solutions/7509679/java-simple-solution-by-tbekpro-2tzj/
    public List<Integer> goodIndices(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int n = numOfChars(i);
            String t = s.substring(Math.max(i - n + 1, 0), i + 1);
            int k = Integer.parseInt(t);
            if (i == k) list.add(i);
        }

        return list;
    }

    private int numOfChars(int a) {
        if (a < 10) return 1;
        else if (a < 100) return 2;
        else if (a < 1000) return 3;
        else if (a < 10000) return 4;
        else if (a < 100_000) return 5;

        return 6;
    }
}
