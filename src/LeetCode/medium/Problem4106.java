package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem4106 {
    //5min
    //Runtime
    //4
    //ms
    //Beats
    //14.34%
    //Memory
    //46.72
    //MB
    //Beats
    //14.28%
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            } else if (sb1.length() > 0) {
                list.add(List.of(sb1.toString(), sb2.toString()));
                sb1.setLength(0);
                sb2.setLength(0);
            }
        }

        if (sb1.length() > 0) {
            list.add(List.of(sb1.toString(), sb2.toString()));
            sb1.setLength(0);
            sb2.setLength(0);
        }

        return list;
    }
}
