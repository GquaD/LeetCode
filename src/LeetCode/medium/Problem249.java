package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem249 {
    //https://leetcode.com/problems/group-shifted-strings/
    public static void main(String[] args) {

    }

    //nnn
    //30min
    //Runtime
    //2
    //ms
    //Beats
    //81.03%
    //of users with Java
    //Memory
    //42.80
    //MB
    //Beats
    //86.73%
    //of users with Java
    public List<List<String>> groupStrings(String[] st) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : st) {
            String seq = findSequence(s);
            List<String> list = map.get(seq);
            if (list == null) {
                list = new ArrayList<>();
                map.put(seq, list);
            }
            list.add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String findSequence(String s) {
        if (s.length() == 1) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append((s.charAt(i) - s.charAt(0) + 26) % 26);
            sb.append("_");
        }
        return sb.toString();
    }
}
