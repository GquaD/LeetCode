package LeetCode.medium;

import java.util.*;

public class Problem1817 {
    //https://leetcode.com/problems/finding-the-users-active-minutes/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findingUsersActiveMinutes(new int[][]{
                {0,5},
                {1,2},
                {0,2},
                {0,5},
                {1,3}
        }, 5)));

        System.out.println(Arrays.toString(findingUsersActiveMinutes(new int[][]{
                {1,1},
                {2,2},
                {2,3}
        }, 4)));
    }

    //Runtime: 36 ms, faster than 51.40% of Java online submissions for Finding the Users Active Minutes.
    //Memory Usage: 138.8 MB, less than 12.78% of Java online submissions for Finding the Users Active Minutes.
    static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if (!map.containsKey(logs[i][0])) {
                Set<Integer> set = new HashSet<>();
                set.add(logs[i][1]);
                map.put(logs[i][0], set);
            } else {
                map.get(logs[i][0]).add(logs[i][1]);
            }
        }
        int[] res = new int[k];
        for (Integer key : map.keySet()) {
            int amountOfUAM = map.get(key).size();
            res[amountOfUAM - 1]++;
        }
        return res;
    }
}
