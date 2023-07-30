package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem1324 {
    //https://leetcode.com/problems/print-words-vertically/
    public static void main(String[] args) {
        LeetCodeUtils.printList(printVertically("TO BE OR NOT TO BE"));
        LeetCodeUtils.printList(printVertically("HOW ARE YOU"));
    }

    //https://leetcode.com/problems/print-words-vertically/solutions/3839143/java-1ms-list-of-stringbuilder/
    //25 min
    //Runtime
    //1 ms
    //Beats
    //69.17%
    //Memory
    //40.8 MB
    //Beats
    //81.25%
    static List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int maxLen = arr[0].length();
        for (int i = 0; i < arr.length; i++) maxLen = Math.max(arr[i].length(), maxLen);
        List<StringBuilder> list = new ArrayList<>();
        for (int c = 0; c < arr.length; c++) {
            for (int r = 0; r < maxLen; r++) {
                if (c == 0) list.add(new StringBuilder());
                if (r < arr[c].length()) list.get(r).append(arr[c].charAt(r));
                else list.get(r).append(" ");
            }
        }
        List<String> res = new ArrayList<>();
        for (StringBuilder sb : list) res.add(trimEnd(sb.toString()));
        return res;
    }

    private static String trimEnd(String s) {
        int idx = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                idx = i;
                break;
            }
        }
        return s.substring(0, idx + 1);
    }
}
