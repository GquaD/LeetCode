package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem997 {
    //https://leetcode.com/problems/find-the-town-judge/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-town-judge/solutions/3088775/java-using-array-of-sets
    //15 -20 min
    //Runtime
    //11 ms
    //Beats
    //41.15%
    //Memory
    //50.2 MB
    //Beats
    //58.91%

    static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        if (n == 1) return trust[0][1];
        Set<Integer>[] arr = new Set[n + 1];
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            if (arr[a] == null) arr[a] = new HashSet<>();
            arr[a].add(b);
        }
        int count = 0, idx = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i] == null) {
                count++;
                idx = i;
            }
        }
        if (count > 1) return -1;
        for (int i = 1; i <= arr.length; i++) {
            if (i == idx) continue;
            if (!arr[i].contains(idx)) return -1;
        }
        return idx;
    }
}
