package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem288 {
    //https://leetcode.com/problems/unique-word-abbreviation/

}
//https://leetcode.com/problems/unique-word-abbreviation/solutions/5453951/java-straightforward-solution/
    //25min
    //Runtime
    //64
    //ms
    //Beats
    //83.87%
    //Analyze Complexity
    //Memory
    //57.70
    //MB
    //Beats
    //6.45%
class ValidWordAbbr {

    StringBuilder sb;
    Set<String> set;
    Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        sb = new StringBuilder();
        set = new HashSet<>();
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = abbr(s);
            set.add(abbr);
            Set<String> t = map.get(abbr);
            if (t == null) {
                t = new HashSet<>();
                map.put(abbr, t);
            }
            t.add(s);
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbr(word);
        if (!set.contains(abbr)) {
            return true;
        } else if (map.containsKey(abbr)) {
            Set<String> t = map.get(abbr);
            if (t.contains(word) && t.size() > 1) {
                return false;
            }
            return t.contains(word) ? t.size() == 1 : false;
        }
        return false;
    }

    private String abbr(String w) {
        sb.setLength(0);
        sb.append(w.charAt(0));
        String mid = w.length() - 2 > 0 ? (w.length() - 2) + "" : "";
        sb.append(mid);
        sb.append(w.charAt(w.length() - 1));
        return sb.toString();
    }
}
