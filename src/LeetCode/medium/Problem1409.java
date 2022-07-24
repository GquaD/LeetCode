package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1409 {
    //https://leetcode.com/problems/queries-on-a-permutation-with-key/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(processQueries(new int[]{3, 1, 2, 1}, 5)));
        System.out.println(Arrays.toString(processQueries(new int[]{4, 1, 2, 2}, 4)));
        System.out.println(Arrays.toString(processQueries(new int[]{7, 5, 5, 8, 3}, 8)));
    }

    //Runtime: 17 ms, faster than 31.54% of Java online submissions for Queries on a Permutation With Key.
    //Memory Usage: 43.8 MB, less than 16.15% of Java online submissions for Queries on a Permutation With Key.
    static int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        for (int i = 0; i < res.length; i++) {
            int pos = findPosFromP(queries[i], list);
            res[i] = pos;
        }
        return res;
    }

    private static int findPosFromP(int num, List<Integer> list) {
        int pos = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
                pos = i;
                list.remove(i);
                list.add(0, num);
                break;
            }
        }
        return pos;
    }
}
