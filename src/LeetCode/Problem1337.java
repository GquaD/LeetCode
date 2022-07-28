package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1337 {
    //https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        }, 3)));
    }

    //Runtime: 4 ms, faster than 36.45% of Java online submissions for The K Weakest Rows in a Matrix.
    //Memory Usage: 48.8 MB, less than 48.90% of Java online submissions for The K Weakest Rows in a Matrix.
    static int[] kWeakestRows(int[][] mat, int k) {
        int[] countSoldiers = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            int j = 0;
            while (j < mat[0].length && mat[i][j] != 0) {
                j++;
                count++;
            }
            countSoldiers[i] = count;
        }
        List<PairMy> list = new ArrayList<>();
        for (int i = 0; i < countSoldiers.length; i++) {
            PairMy pair = new PairMy();
            pair.index = i;
            pair.numberOfSoldiers = countSoldiers[i];
            list.add(pair);
        }

        list = list.stream().sorted((o1, o2) -> o1.numberOfSoldiers - o2.numberOfSoldiers).collect(Collectors.toList());
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).index;
        }
        return res;
    }

    static class PairMy {
        int index;
        int numberOfSoldiers;
    }
}
