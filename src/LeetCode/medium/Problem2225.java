package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2225 {
    //https://leetcode.com/problems/find-players-with-zero-or-one-losses/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }

    //Runtime: 593 ms, faster than 13.82% of Java online submissions for Find Players With Zero or One Losses.
    //Memory Usage: 146.5 MB, less than 63.17% of Java online submissions for Find Players With Zero or One Losses.
    static List<List<Integer>> findWinners(int[][] matches) {
        //person -> frequency
        Map<Integer, Integer> losers = new TreeMap<>();
        Set<Integer> winners = new TreeSet<>();
        for (int[] m : matches) {
            int key = m[1];
            if (losers.containsKey(key)) {
                losers.put(key, losers.get(key) + 1);
            } else {
                losers.put(key, 1);
            }
            winners.add(m[0]);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> loserList = new ArrayList<>();
        List<Integer> winnerList = new ArrayList<>();
        for (Integer loser : losers.keySet()) {
            if (losers.get(loser) == 1) {
                loserList.add(loser);
            }
        }
        for (Integer winner : winners) {
            if (!losers.containsKey(winner)) {
                winnerList.add(winner);
            }
        }
        result.add(winnerList);
        result.add(loserList);
        return result;
    }
}
