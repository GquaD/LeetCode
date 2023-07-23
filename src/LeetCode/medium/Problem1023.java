package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem1023 {
    //https://leetcode.com/problems/camelcase-matching/
    public static void main(String[] args) {
        LeetCodeUtils.printList(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
        LeetCodeUtils.printList(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        LeetCodeUtils.printList(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }

    //https://leetcode.com/problems/camelcase-matching/solutions/3806329/java-straightforward-solution/
    //15-20 min
    //Runtime
    //1 ms
    //Beats
    //31.41%
    //Memory
    //40.3 MB
    //Beats
    //97.11%
    static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            int c = 0;
            for (int j = 0; j < s.length(); j++) {
                if (c < pattern.length() && s.charAt(j) == pattern.charAt(c)) {
                    c++;
                } else if (Character.isUpperCase(s.charAt(j))) {
                    list.add(false);
                    break;
                }
            }
            if (list.size() < i + 1) list.add(c >= pattern.length());

            /*if (c < pattern.length()) list.add(false);
            else if () list.add(true);*/

        }
        return list;
    }
}
