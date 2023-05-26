package LeetCode.medium;

import java.util.*;

public class Problem2661 {
    //https://leetcode.com/problems/first-completely-painted-row-or-column/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //60 ms
    //Beats
    //23.58%
    //Memory
    //70.1 MB
    //Beats
    //24.98%
    static int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> mapC = new HashMap<>(), mapR = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mapR.put(mat[i][j], i);
                mapC.put(mat[i][j], j);
            }
        }
        int[] rows = new int[arr.length], cols = new int[mat[0].length];
        for (int i = 0; i < arr.length; i++) {
            int r = mapR.get(arr[i]), c = mapC.get(arr[i]);
            if (++rows[r] == mat[0].length || ++cols[c] == mat.length) return i;
        }
        return arr.length - mat.length;
    }

    //Time Limit Exceeded
    //1056 / 1058
    static int firstCompleteIndex2(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length, max = Math.max(m, n);
        HashSet<Integer>[] rows = new HashSet[m], cols = new HashSet[n];
        for (int i = 0; i < m; i++) rows[i] = new HashSet<>();
        for (int i = 0; i < n; i++) cols[i] = new HashSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                rows[r].add(mat[r][c]);
                cols[c].add(mat[r][c]);
            }
        }
        int[] countR = new int[m], countC = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int r = 0; r < m; r++) {
                if (rows[r].contains(num)) {
                    if (rows[r].size() == ++countR[r]) return i;
                    break;
                }
            }
            for (int c = 0; c < n; c++) {
                if (cols[c].contains(num)) {
                    if (cols[c].size() == ++countC[c]) return i;
                    break;
                }
            }
        }
        return arr.length - max;
    }

    //Time Limit Exceeded
    //1055 / 1058
    static int firstCompleteIndex1(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length, max = Math.max(m, n);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int c = 0; c < mat[0].length; c++) {
                boolean filled = true;
                for (int r = 0; r < mat.length; r++) {
                    if (!set.contains(mat[r][c])) {
                        filled = false;
                        break;
                    }
                }
                if (filled) return i;
            }
            for (int r = 0; r < mat.length; r++) {
                boolean filled = true;
                for (int c = 0; c < mat[0].length; c++) {
                    if (!set.contains(mat[r][c])) {
                        filled = false;
                        break;
                    }
                }
                if (filled) return i;
            }
        }

        return arr.length - max;
    }
}
