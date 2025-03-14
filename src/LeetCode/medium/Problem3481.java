package LeetCode.medium;

import java.util.List;

public class Problem3481 {
    //https://leetcode.com/problems/apply-substitutions
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/apply-substitutions/solutions/6536010/java-solution-by-tbekpro-48d5/
    //30min
    //Runtime
    //6
    //ms
    //Beats
    //75.00%
    //Analyze Complexity
    //Memory
    //45.80
    //MB
    //Beats
    //14.29%
    public String applySubstitutions(List<List<String>> replacements, String text) {
        String[] split = text.split("_");
        String[] rep = new String[26];
        StringBuilder sb = new StringBuilder();
        for (List<String> pair: replacements) rep[pair.get(0).charAt(0) - 'A'] = pair.get(1);
        for (int i = 0; i < 26; i++) {
            String cur = rep[i];
            if (cur == null) continue;
            while (cur.contains("%")) {
                int idx = cur.indexOf("%") + 1;
                String r = rep[cur.charAt(idx) - 'A'];
                sb.append(cur.substring(0, idx - 1));
                sb.append(r);
                sb.append(cur.substring(idx + 2));
                cur = sb.toString();
                sb.setLength(0);
            }
            rep[i] = cur;
        }

        for (String s: split) {
            sb.append(rep[s.charAt(1) - 'A']).append("_");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}
