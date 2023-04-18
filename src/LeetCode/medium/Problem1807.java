package LeetCode.medium;

import java.util.*;

public class Problem1807 {
    //https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("name", "bob"));
        list.add(Arrays.asList("age", "two"));
        System.out.println(evaluate("(name)is(age)yeatsold", list));
    }

    //https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/solutions/3429162/java-o-n-solution/
    //10 - 15 min
    //Runtime
    //43 ms
    //Beats
    //54.36%
    //Memory
    //83.2 MB
    //Beats
    //36.91%
    static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) map.put(pair.get(0), pair.get(1));
        StringBuilder sb = new StringBuilder(), sbMain = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                while (s.charAt(++i) != ')') sb.append(s.charAt(i));
                String v = map.get(sb.toString());
                sbMain.append(v == null ? "?" : v);
                sb.setLength(0);
                continue;
            }
            if (c != ')') sbMain.append(c);
        }
        return sbMain.toString();
    }
}
