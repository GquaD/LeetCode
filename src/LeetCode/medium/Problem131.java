package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem131 {
    //https://leetcode.com/problems/palindrome-partitioning/description/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfStrings(partition("aab"));
        System.out.println();
        LeetCodeUtils.printListWithListsOfStrings(partition("a"));
        System.out.println();
        LeetCodeUtils.printListWithListsOfStrings(partition("aaab"));
        System.out.println();
        LeetCodeUtils.printListWithListsOfStrings(partition("abcaa"));
        System.out.println();
        LeetCodeUtils.printListWithListsOfStrings(partition("abbab"));
    }

    //Time limit exception on 31/32
    static List<List<String>> partition(String s) {
        Set<List<String>> set = new HashSet<>();
        goRecursively(0, 1, s, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private static void goRecursively(int start, int end, String s,
                                      List<String> list, Set<List<String>> set) {
        if (listLength(list) >= s.length()) {
            set.add(new ArrayList<>(list));
            return;
        }

        if (end > s.length()) return;

        String temp = s.substring(start, Math.min(end, s.length()));
        if (isPalindrome(temp)) {
            list.add(temp);
            for (int i = end; i <= s.length(); i++) {
                //int size = list.size();
                goRecursively(end, i + 1, s, list, set);
                //list = list.subList(0, size);
            }
            list.remove(list.size() - 1);
        }
        if (!temp.isEmpty()){
            goRecursively(start, end + 1, s, list, set);
        }
    }

    private static int listLength(List<String> list) {
        int len = 0;
        for (String s : list) len += s.length();
        return len;
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
}
