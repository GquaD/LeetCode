package LeetCode.medium;

import java.util.*;

public class Problem1451 {
    //https://leetcode.com/problems/rearrange-words-in-a-sentence


    //https://leetcode.com/problems/rearrange-words-in-a-sentence/solutions/5606967/java-using-treemap/
    //10min
    //Runtime
    //19
    //ms
    //Beats
    //96.66%
    //Analyze Complexity
    //Memory
    //45.48
    //MB
    //Beats
    //58.19%
    String arrangeWords(String text) {
        //len -> list of strings
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String s : text.split(" ")) {
            List<String> l = map.get(s.length());
            if (l == null) {
                l = new ArrayList<>();
                map.put(s.length(), l);
            }
            l.add(s.toLowerCase());
        }
        StringBuilder sb = new StringBuilder();
        for (int len : map.keySet()) {
            List<String> l = map.get(len);
            if (sb.length() == 0) {
                String s = l.get(0);
                sb.append((char)(s.charAt(0) - 32));
                sb.append(s.substring(1));
                for (int i = 1; i < l.size(); i++) {
                    sb.append(" ");
                    sb.append(l.get(i));
                }
                continue;
            }
            for (int i = 0; i < l.size(); i++) {
                sb.append(" ");
                sb.append(l.get(i));
            }
        }
        return sb.toString();
    }
}
