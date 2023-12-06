package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2924 {
    //https://leetcode.com/problems/find-champion-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-champion-ii/solutions/4370304/java-hashset-o-n-solution/
    //10-15 min
    //Runtime
    //4 ms
    //Beats
    //43.6%
    //Memory
    //44.6 MB
    //Beats
    //72.92%
    static int findChampion(int n, int[][] edges) {
        if (n == 1) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (int[] arr : edges) {
            set.remove(arr[1]);
        }

        if (set.size() == 1) {
            for (int h : set) {
                return h;
            }
        }
        return -1;
    }
}
