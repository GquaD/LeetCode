package LeetCode.medium;

import LeetCode.LeetCodeUtils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem973 {
    //https://leetcode.com/problems/k-closest-points-to-origin/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(kClosest(new int[][]{{1,3}, {-2, 2}}, 1));
    }

    //https://leetcode.com/problems/k-closest-points-to-origin/solutions/3779519/java-6-lines-sort/
    //10-15min
    //Runtime
    //Details
    //49ms
    //Beats 26.90%of users with Java
    //Memory
    //Details
    //55.09mb
    //Beats 11.42%of users with Java
    static int[][] kClosest(int[][] points, int k) {
        List<Pair<int[], Double>> list = new ArrayList<>();
        for (int[] arr : points) list.add(new Pair<>(arr, Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2))));
        Collections.sort(list, (a, b) -> (int) (a.getValue() * 100 - b.getValue() * 100));
        int[][] res = new int[k][2];
        for (int i = 0; i < Math.min(k, list.size()); i++) res[i] = list.get(i).getKey();
        return res;
    }
}
