package LeetCode.medium;

import java.util.Arrays;

public class Problem2120 {
    //https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
        System.out.println(Arrays.toString(executeInstructions(2, new int[]{1, 1}, "LURD")));
    }

    //Runtime: 112 ms, faster than 18.03% of Java online submissions for Execution of All Suffix Instructions Staying in a Grid.
    //Memory Usage: 46.3 MB, less than 46.17% of Java online submissions for Execution of All Suffix Instructions Staying in a Grid.

    //after adding short types
    //Runtime: 93 ms, faster than 26.42% of Java online submissions for Execution of All Suffix Instructions Staying in a Grid.
    //Memory Usage: 46.5 MB, less than 38.77% of Java online submissions for Execution of All Suffix Instructions Staying in a Grid.
    static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] steps = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            short row = (short) startPos[0], col = (short) startPos[1];
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'L') {
                    if (moveExists(n, row, --col)) {
                        steps[i]++;
                        continue;
                    } else break;
                }
                if (s.charAt(j) == 'U') {
                    if (moveExists(n, --row, col)) {
                        steps[i]++;
                        continue;
                    } else break;
                }
                if (s.charAt(j) == 'D') {
                    if (moveExists(n, ++row, col)) {
                        steps[i]++;
                        continue;
                    } else break;
                }
                if (s.charAt(j) == 'R') {
                    if (moveExists(n, row, ++col)) {
                        steps[i]++;
                        continue;
                    } else break;
                }
            }
        }
        return steps;
    }

    static boolean moveExists(int n, int x, int y) {
        return !(x >= n || y >= n || x < 0 || y < 0);
    }
}
