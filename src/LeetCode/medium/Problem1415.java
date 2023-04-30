package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Problem1415 {
    //https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
    public static void main(String[] args) {
        System.out.println(getHappyString(3, 10));
        System.out.println(getHappyString(3, 9));
        System.out.println(getHappyString(1, 3));
        System.out.println(getHappyString(1, 4));
    }

    //https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/solutions/3468944/java-4-ms-solution/
    //20-25min
    //Runtime
    //4 ms
    //Beats
    //64.71%
    //Memory
    //42.1 MB
    //Beats
    //64.71%
    static String getHappyString(int n, int k) {
        comb = "";
        List<String> list = new ArrayList<>();
        generateComb(n, k, list, new StringBuilder());
        if (list.size() == k) return list.get(list.size() - 1);
        return comb;
    }

    private static void generateComb(int n, int k, List<String> list, StringBuilder sb) {
        if (list.size() == k) return;

        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (char c : chars) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == c) continue;
            sb.append(c);
            generateComb(n, k, list, sb);
            sb.replace(sb.length()- 1, sb.length(), "");
        }
    }

    //20-25 min
    //Runtime
    //5 ms
    //Beats
    //62.3%
    //Memory
    //42.6 MB
    //Beats
    //54.1%
    static String comb;
    static char[] chars = new char[]{'a', 'b', 'c'};
    static String getHappyString1(int n, int k) {
        comb = "";
        LinkedHashSet<String> set = new LinkedHashSet<>();
        generateComb(n, k, set, new StringBuilder());
        if (set.size() == k) for (String s : set) comb = s;
        return comb;
    }

    private static void generateComb(int n, int k, LinkedHashSet<String> set, StringBuilder sb) {
        if (set.size() == k) return;

        if (sb.length() == n) {
            set.add(sb.toString());
            return;
        }
        for (char c : chars) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == c) continue;
            sb.append(c);
            generateComb(n, k, set, sb);
            sb.replace(sb.length()- 1, sb.length(), "");
        }
    }
}
