package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3955 {
    //15min

    //Runtime
    //146
    //ms
    //Beats
    //100.00%
    //Memory
    //47.17
    //MB
    //Beats
    //100.00%
    public List<String> generateValidStrings(int n, int k) {
        Set<String> set = new HashSet<>();
        generate(n, k, new StringBuilder(), set);
        return new ArrayList<>(set);
    }

    private String generate(int n, int k, StringBuilder sb, Set<String> set) {
        if (sb.length() >= n) {
            String s = sb.toString();
            if (isValid(s, k)) set.add(s);
            return s;
        }

        int len = sb.length();
        sb.append(0);
        generate(n, k, sb, set);
        sb.setLength(len);
        sb.append(1);
        generate(n, k, sb, set);
        sb.setLength(len);
        return "";
    }

    private boolean isValid(String s, int k) {
        int cost = 0;
        boolean valid = true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') valid = false;
            if (s.charAt(i) == '1') cost += i;
        }
        if (s.charAt(s.length() - 1) == '1') cost += s.length() - 1;

        return valid && cost <= k;
    }
}
