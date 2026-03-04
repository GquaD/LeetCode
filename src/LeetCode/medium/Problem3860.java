package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem3860 {
    //5-10min
    //Runtime
    //61
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //47.81
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/unique-email-groups
    StringBuilder sb;
    public int uniqueEmailGroups(String[] emails) {
        sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (String email: emails) set.add(normalize(email));
        return set.size();
    }

    private String normalize(String email) {
        String[] split = email.split("@");
        for (int i = 0; i < split[0].length(); i++) {
            char c = split[0].charAt(i);
            if (c == '+') break;
            if (c != '.') {
                if (c >= 'A' && c <= 'Z') {
                    c = (char)('a' + (c - 'A'));
                }
                sb.append(c);
            }
        }
        sb.append('@');
        for (int i = 0; i < split[1].length(); i++) {
            char c = split[1].charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)('a' + (c - 'A'));
            }
            sb.append(c);
        }
        String result = sb.toString();
        sb.setLength(0);
        return result;
    }


}
