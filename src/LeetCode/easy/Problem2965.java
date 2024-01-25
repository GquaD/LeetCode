package LeetCode.easy;
import java.util.*;

public class Problem2965 {
    //https://leetcode.com/problems/find-missing-and-repeated-values/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-missing-and-repeated-values/solutions/4625800/java-o-n-100-faster-no-hashmap-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.75
    //MB
    //Beats
    //6.49%
    //of users with Java
    static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, arr[] = new int[n * n + 1], res[] = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[grid[i][j]]++;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 2) res[0] = i;
            else if (arr[i] == 0) res[1] = i;
        }

        return res;
    }

    //5min
    //Runtime
    //7
    //ms
    //Beats
    //24.15%
    //of users with Java
    //Memory
    //45.19
    //MB
    //Beats
    //29.58%
    //of users with Java
    static int[] findMissingAndRepeatedValues2(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= grid.length * grid.length; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                map.put(grid[i][j], map.get(grid[i][j]) + 1);
            }
        }

        int[] res = new int[2];

        for (int k : map.keySet()) {
            int f = map.get(k);
            if (f == 2) res[0] = k;
            else if (f == 0) res[1] = k;
        }
        return res;
    }

    static int[] findMissingAndRepeatedValues1(int[][] grid) {
        int[] arr = new int[grid.length * grid.length];
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                arr[c++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int[] res = new int[2];
        c = 1;
        for (int i = 0; i < arr.length; i++) {
            if (c != arr[i]) {
                res[1] = arr[c];
                break;
            }
            c++;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                res[0] = arr[i];
                break;
            }
        }
        return res;
    }
}
