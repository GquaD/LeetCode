package LeetCode.easy;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1854 {
    //https://leetcode.com/problems/maximum-population-year/
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{2038,2040},{1988,2030},{1952,1974},{1956,1978},{2040,2047},{1994,2011},{1976,2044},{2038,2043},{2012,2023},{2049,2050},{2034,2049},{2015,2022},{1988,1998},{2037,2046},{2039,2048},{2045,2050},{2034,2046},{2014,2025},{2009,2026},{1976,2007},{2021,2045},{1995,2000},{2009,2042},{2027,2037},{2004,2009},{1955,1990},{2001,2042},{2009,2042},{1992,2010},{1958,1968}}));
    }

    //
    //20-30 min
    //Runtime
    //3 ms
    //Beats
    //12.60%
    //Memory
    //41.1 MB
    //Beats
    //27.51%
    static int maximumPopulation(int[][] logs) {
        int[][] arr = new int[logs.length * 2][2];
        for (int i = 0; i < logs.length; i++) {
            arr[i * 2] = new int[]{logs[i][0], 1};
            arr[i * 2 + 1] = new int[]{logs[i][1], -1};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int max = 0, year = 1900, count = 0;
        for (int[] a : arr) {
            count += a[1];
            if (max < count) {
                max = count;
                year = a[0];
            }
        }
        return year;
    }

    //Wrong Answer
    //
    //40 / 52
    static int maximumPopulation1(int[][] logs) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() == b.getKey() ? a.getValue() - b.getValue() : a.getKey() - b.getKey());
        for (int[] arr : logs) {
            pq.offer(new Pair<>(arr[0], 1));
            pq.offer(new Pair<>(arr[1], -1));
        }
        int max = 0, year = 1900, count = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            count += pair.getValue();
            if (max < count) {
                max = count;
                year = pair.getKey();
            }
        }
        return year;
    }
}
