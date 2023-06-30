package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1624 {
    //https://leetcode.com/problems/largest-substring-between-two-equal-characters/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/largest-substring-between-two-equal-characters/solutions/3698504/java-using-hashmap-char-list-of-int/
    //5-10 min
    //Runtime
    //3 ms
    //Beats
    //29.17%
    //Memory
    //40.6 MB
    //Beats
    //43.91%
    int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        int max = -1;
        for (char c : map.keySet()) {
            List<Integer> l = map.get(c);
            if (l.size() > 1) max = Math.max(max, l.get(l.size() - 1) - l.get(0) - 1);
        }
        return max;
    }
}
