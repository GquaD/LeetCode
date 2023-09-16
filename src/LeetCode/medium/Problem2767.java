package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2767 {
    //https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/

    public static void main(String[] args) {
        System.out.println(minimumBeautifulSubstrings("1011011111011"));
        System.out.println(minimumBeautifulSubstrings("1011"));
        System.out.println(minimumBeautifulSubstrings("111"));
        System.out.println(minimumBeautifulSubstrings("0"));
    }

    //https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/solutions/4051643/java-brute-force-solution/
    //25 min
    //Runtime
    //50 ms
    //Beats
    //5.62%
    //Memory
    //44.7 MB
    //Beats
    //5.39%
    static List<String> list;

    static int minimumBeautifulSubstrings(String s) {
        if (list == null) generateBinaryStrings();

        int count = 0, min = Integer.MAX_VALUE;
        for (String num : list) {
            String temp = new String(s);
            int start = list.indexOf(num);
            for (int i = start; i < list.size(); i++) {
                String curr = list.get(i);
                while (temp.contains(curr)) {
                    int idx = temp.indexOf(curr);
                    if (idx >= 0) {
                        String stub = generateStubString(curr);
                        temp = temp.replaceFirst(curr, stub);
                        count++;
                    }
                }
            }
            if (countA(temp) == s.length()) min = Math.min(count, min);
            count = 0;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int countA(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'a') c++;
        return c;
    }

    private static String generateStubString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) sb.append('a');
        return sb.toString();
    }

    private static void generateBinaryStrings() {
        int n = 1;
        list = new ArrayList<>();
        while (n > 0) {
            list.add(Integer.toBinaryString(n));
            n *= 5;
        }
        Collections.reverse(list);
    }
}
