package LeetCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem2768 {
    //https://leetcode.com/problems/number-of-black-blocks/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBlackBlocks(3, 3, new int[][]{{0, 0}})));
        System.out.println(Arrays.toString(countBlackBlocks(3, 3, new int[][]{{0, 0}, {1, 1}, {0, 2}})));
    }

    //nnn
    //Runtime
    //240 ms
    //Beats
    //33.33%
    //Memory
    //56.6 MB
    //Beats
    //14.94%
    static long[] countBlackBlocks(int m, int n, int[][] coor) {
        HashMap<Long, Integer> map = new HashMap<>();
        long possible = (m - 1L) * (n - 1L);
        long[] res = {possible, 0, 0, 0, 0};
        for (int[] c : coor) {
            for (int i = c[0]; i < c[0] + 2; i++) {
                for (int j = c[1]; j < c[1] + 2; j++) {
                    if (cellExists(i, j, m, n)) {
                        long idx = i * 100_000L + j;
                        res[map.getOrDefault(idx, 0)]--;
                        map.put(idx, map.getOrDefault(idx, 0) + 1);
                        res[map.getOrDefault(idx, 0)]++;
                    }
                }
            }
        }
        return res;
    }

    static long[] countBlackBlocks2(int m, int n, int[][] coor) {
        Set<String> set = new HashSet<>();

        for (int[] arr : coor) {
            set.add(arr[0] + "_" + arr[1]);
        }

        Set<String> visited = new HashSet<>();
        long[] res = new long[5];

        for (int[] arr : coor) {
            int x = arr[0], y = arr[1], count = 0;
            String first = (y - 1) + "_" + (x - 1);
            if (cellExists(y - 1, x - 1, n, m) && cellExists(y, x, n, m)) {
                if (!visited.contains(first)) {
                    visited.add(first);

                    if (set.contains(first)) count++;
                    if (set.contains((y - 1) + "_" + x)) count++;
                    if (set.contains(y + "_" + (x - 1))) count++;
                    if (set.contains(y + "_" + x)) count++;

                    res[count]++;
                }
            }

            count = 0;
            String second = (y - 1) + "_" + x;
            if (cellExists(y - 1, x, n, m) && cellExists(y, x + 1, n, m)) {
                if (!visited.contains(second)) {
                    visited.add(second);

                    if (set.contains(second)) count++;
                    if (set.contains((y - 1) + "_" + (x + 1))) count++;
                    if (set.contains(y + "_" + x)) count++;
                    if (set.contains(y + "_" + (x + 1))) count++;
                    res[count]++;
                }
            }


            count = 0;
            String third = y + "_" + (x - 1);
            if (cellExists(y, x - 1, n, m) && cellExists(y + 1, x, n, m)) {
                if (!visited.contains(third)) {
                    visited.add(third);

                    if (set.contains(third)) count++;
                    if (set.contains(y + "_" + x)) count++;
                    if (set.contains((y + 1) + "_" + (x - 1))) count++;
                    if (set.contains((y + 1) + "_" + x)) count++;
                    res[count]++;
                }
            }

            count = 0;
            String fourth = y + "_" + x;
            if (cellExists(y, x, n, m)) {
                if (cellExists(y, x, n, m) && cellExists(y + 1, x + 1, n, m)) {
                    visited.add(fourth);

                    if (set.contains(fourth)) count++;
                    if (set.contains(y + "_" + (x + 1))) count++;
                    if (set.contains((y + 1) + "_" + x)) count++;
                    if (set.contains((y + 1) + "_" + (x + 1))) count++;
                    res[count]++;
                }
            }
        }
        long possible = (m - 1L) * (n - 1L);
        for (int i = 0; i < res.length; i++) {
            possible -= res[i];
        }
        res[0] = possible;
        return res;
    }

    private static boolean cellExists(int y, int x, int n, int m) {
        return y > 0 && y < n && x > 0 && x < m;
    }


    static long[] countBlackBlocks1(int m, int n, int[][] coor) {
        int[][] arr = new int[m][n];
        for (int[] r : coor) {
            arr[r[1]][r[0]]++;
        }
        long[] res = new long[5];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int c = 0;
                if (coor[i][j] > 0) c++;
                if (coor[i][j + 1] > 0) c++;
                if (coor[i + 1][j] > 0) c++;
                if (coor[i + 1][j + 1] > 0) c++;
                res[c]++;
            }
        }
        return res;
    }
}
