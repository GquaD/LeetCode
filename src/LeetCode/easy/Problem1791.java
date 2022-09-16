package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem1791 {
    //https://leetcode.com/problems/find-center-of-star-graph/
    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{
                {1,2},
                {2,3},
                {4,2}
        }));
        System.out.println(findCenter(new int[][]{
                {1,2},
                {5,1},
                {1,3},
                {1,4}
        }));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Center of Star Graph.
    //Memory Usage: 65.2 MB, less than 98.03% of Java online submissions for Find Center of Star Graph.
    static int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                int n = edges[i][j];
                if (!set.contains(n)) {
                    set.add(n);
                } else {
                    return n;
                }
            }
        }
        return 0;
    }
}
