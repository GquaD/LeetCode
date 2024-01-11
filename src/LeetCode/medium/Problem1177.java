package LeetCode.medium;
import java.util.*;

public class Problem1177 {
    //https://leetcode.com/problems/can-make-palindrome-from-substring/
    public static void main(String[] args) {

    }

    //20min
    //Time Limit Exceeded
    //29 / 31 testcases passed
    static List<Boolean> canMakePaliQueries(String s, int[][] q) {
        Map<String, Integer> map = new HashMap<>();
        List<Boolean> list = new ArrayList<>();
        for (int[] arr : q) {
            int a = arr[0], b = arr[1], k = arr[2];
            String key = a + " " + b;
            if (map.containsKey(key)) {
                int m = map.get(key);
                if (k >= m) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            } else {
                int m = toBePalindrome(s.substring(a, b + 1));
                map.put(key, m);
                if (k >= m) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            }
        }
        return list;
    }

    private static int toBePalindrome(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        if (s.length() % 2 == 0) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] % 2 == 1) count++;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (arr[i] % 2 == 1) count++;
            }
            count--;
        }

        int diff = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                diff++;
            }
        }
        return Math.min(count / 2, diff);
    }
}
