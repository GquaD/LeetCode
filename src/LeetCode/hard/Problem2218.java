package LeetCode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2218 {
    //https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
    public static void main(String[] args) {
        List<Integer> p1 = Arrays.asList(1,100,3), p2 = Arrays.asList(7,8,9);
        List<List<Integer>> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        System.out.println(maxValueOfCoins(list, 2));
    }

    //nnnn
    //Runtime
    //242 ms
    //Beats
    //37.58%
    //Memory
    //45.2 MB
    //Beats
    //68.64%
    static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        return dynProg(piles, dp, 0, k);
    }

    private static int dynProg(List<List<Integer>> piles, int[][] dp, int i, int k) {
        if (k == 0 || i == piles.size()) return 0;
        if (dp[i][k] != 0) return dp[i][k];

        int curr = 0, res = dynProg(piles, dp, i + 1, k);
        for (int j = 0; j < Math.min(piles.get(i).size(), k); j++) {
            curr += piles.get(i).get(j);
            res = Math.max(res, curr + dynProg(piles, dp, i + 1, k - j - 1));
        }
        return dp[i][k] = res;
    }

    static int maxValueOfCoins1(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        /*for (int i = 0; i < piles.size(); i++) {
            for (int j = 0; j < k && j < piles.get(i).size(); j++) {
                dp[i + 1][j + 1] = piles.get(i).get(j);
            }
        }*/

        /*for (int i = 0; i < piles.size(); i++) {
            for (int j = 0; j < k && j < piles.get(i).size(); j++) {
                dp[i + 1][j + 1] = Math.max(piles.get(i).get(j) + dp[i][j], dp[i + 1][j]);
            }
        }*/

        for (int i = 0; i < piles.size(); i++) {
            for (int j = 0; j < piles.get(i).size() && j < dp.length - 1; j++) {
                dp[j + 1][i + 1] = piles.get(i).get(j);
            }
        }

        /*for (int c = 0; c < dp[0].length - 1; c++) {
            for (int r = 0; r < dp.length - 1; r++) {
                if (c < piles.get(r).size()) dp[r + 1][c + 1] = piles.get(r).get(c);
            }
        }*/

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j] + dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[piles.size()][k];
    }
}
