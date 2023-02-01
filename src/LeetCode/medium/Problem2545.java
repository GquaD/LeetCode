package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2545 {
    //https://leetcode.com/problems/sort-the-students-by-their-kth-score/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(sortTheStudents(new int[][]{
                {10,6,9,1},
                {7,5,11,2},
                {4,8,3,15}
        }, 2));
    }

    //https://leetcode.com/problems/sort-the-students-by-their-kth-score/solutions/3125621/java-2-lines-solution/
    //10 min
    //Runtime
    //2 ms
    //Beats
    //95.31%
    //Memory
    //51.1 MB
    //Beats
    //96.51%
    static int[][] sortTheStudents(int[][] score, int k) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (int[] a : score) map.put(a[k], a);
        int[][] res = new int[score.length][score[0].length];
        int c = 0;
        for (int key : map.descendingKeySet()) res[c++] = map.get(key);
        return res;
    }

    //2 min
    //Runtime
    //2 ms
    //Beats
    //95.31%
    //Memory
    //52.7 MB
    //Beats
    //67.72%
    static int[][] sortTheStudents1(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
