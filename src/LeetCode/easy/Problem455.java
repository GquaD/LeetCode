package LeetCode.easy;

import java.util.Arrays;

public class Problem455 {
    //https://leetcode.com/problems/assign-cookies/
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,3,4,11,12,13,14}));
        System.out.println(findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }

    //https://leetcode.com/problems/assign-cookies/solutions/3034503/java-o-n-m-5-lines-solution/
    //20 min
    //Runtime
    //8 ms
    //Beats
    //92.96%
    //Memory
    //43.3 MB
    //Beats
    //83%

    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int idx = 0, count = 0, len = Math.min(g.length, s.length);
        for (int i = 0; i < len && idx < s.length; i++) count += s[idx++] >= g[i] ? 1 : (--i - i);
        return count;
    }
}
