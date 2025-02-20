package LeetCode.medium;

import java.util.*;

public class Problem820 {
    //https://leetcode.com/problems/short-encoding-of-words/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/short-encoding-of-words/solutions/6446857/java-on2-solution-by-tbekpro-xu45/
    //30min
    //Runtime
    //820
    //ms
    //Beats
    //5.26%
    //Analyze Complexity
    //Memory
    //44.27
    //MB
    //Beats
    //99.42%
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Set<String> set = new HashSet<>();
        for (String s: words) set.add(s);
        List<String> list = new ArrayList<>(set);
        set.clear();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            boolean isPartOf = false;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                if (list.get(j).endsWith(s)) {
                    if (list.get(j).length() == s.length() && !set.contains(s)) {
                        res += s.length() + 1;
                    }
                    set.add(list.get(j));
                    isPartOf = true;
                    break;
                }
            }

            if (!isPartOf) {
                res += s.length() + 1;
            }
        }
        return res;
    }
}
