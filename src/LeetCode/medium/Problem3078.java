package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3078 {
    //https://leetcode.com/problems/match-alphanumerical-pattern-in-matrix-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/match-alphanumerical-pattern-in-matrix-i/solutions/4892864/java-straightforward-solution/
    //30min
    //Runtime
    //15
    //ms
    //Beats
    //66.67%
    //of users with Java
    //Memory
    //45.93
    //MB
    //Beats
    //8.33%
    //of users with Java
    static int[] findPattern(int[][] board, String[] pattern) {
        int n = board.length, m = board[0].length;
        int r = pattern.length, c = pattern[0].length();

        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < n - r + 1; i++) {
            for (int j = 0; j < m - c + 1; j++) {
                boolean triggered = false;
                outerloop:
                for (int l = i; l < i + r; l++) {
                    for (int k = j; k < j + c; k++) {
                        int b = board[l][k];
                        char p = pattern[l - i].charAt(k - j);
                        if (p >= '0' && p <= '9') {
                            if (p - '0' != b) {
                                triggered = true;
                                break outerloop;
                            }
                        } else {
                            if (map.containsKey(p)) {
                                int t = map.get(p);
                                if (b != t) {
                                    triggered = true;
                                    break outerloop;
                                }
                            } else {
                                if (set.contains(b)) {
                                    triggered = true;
                                    break outerloop;
                                }
                                map.put(p, b);
                                set.add(b);
                            }
                        }
                    }
                }
                map.clear();
                set.clear();
                if (!triggered) return new int[]{i, j};
            }
        }
        return res;
    }
}
