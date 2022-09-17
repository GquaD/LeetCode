package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2405 {
    //https://leetcode.com/problems/optimal-partition-of-string/
    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionString("ssssss"));
    }

    //Runtime: 17 ms, faster than 90.94% of Java online submissions for Optimal Partition of String.
    //Memory Usage: 54.9 MB, less than 69.11% of Java online submissions for Optimal Partition of String.
    static int partitionString(String s) {
        boolean[] letters = new boolean[26];
        int count = 1;
        for (char c : s.toCharArray()) {
            if (!letters[c - 'a']) {
                letters[c - 'a'] = true;
            } else {
                count++;
                letters = new boolean[26];
                letters[c - 'a'] = true;
            }
        }
        return count;
    }

    //Runtime: 30 ms, faster than 77.48% of Java online submissions for Optimal Partition of String.
    //Memory Usage: 45.3 MB, less than 88.26% of Java online submissions for Optimal Partition of String.
    static int partitionString1(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                count++;
                set = new HashSet<>();
                set.add(c);
            }
        }
        return count + 1;
    }
}
