package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1288 {
    //https://leetcode.com/problems/remove-covered-intervals/
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1,4}, {2,3}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1,4}, {3,6}, {2,8}}));
    }

    //https://leetcode.com/problems/remove-covered-intervals/solutions/3834619/java-array-sort-hashset-o-nlogn/
    //15-20 min
    //Runtime
    //8 ms
    //Beats
    //12.95%
    //Memory
    //43.8 MB
    //Beats
    //11.51%
    static int removeCoveredIntervals(int[][] in) {
        Arrays.sort(in, (a,b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        Set<Integer> setRemoved = new HashSet<>();
        int c = in[in.length - 1][0], d = in[in.length - 1][1];
        for (int i = in.length - 2; i >= 0; i--) {
            if (!setRemoved.contains(i)) {
                int a = in[i][0], b = in[i][1];
                if (c <= a && b <= d) setRemoved.add(i);
                else {
                    c = in[i][0];
                    d = in[i][1];
                }
            }
        }
        return in.length - setRemoved.size();
    }
}
