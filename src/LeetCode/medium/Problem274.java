package LeetCode.medium;

import java.util.Arrays;

public class Problem274 {
    //https://leetcode.com/problems/h-index/description/
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0,0,0,0}));
        System.out.println(hIndex(new int[]{11,15}));
        System.out.println(hIndex(new int[]{5,6,1,3,4,9,9}));
        System.out.println(hIndex(new int[]{3,0,6,1,5}));
        System.out.println(hIndex(new int[]{1,2,3,4,5,6,7,8}));
    }

    //https://leetcode.com/problems/h-index/solutions/3231799/java-o-nlogn-solution/
    //1 hour
    //Runtime
    //2 ms
    //Beats
    //26.15%
    //Memory
    //40.5 MB
    //Beats
    //38.11%
    static int hIndex(int[] c) {
        Arrays.sort(c);
        int h = c.length;
        for (int i = 0; i < c.length; i++) {
            if (h > c[i]) h--;
            else break;
        }
        return h;
    }

    static int hIndex3(int[] c) {
        if (c.length == 1) return c[0] == 0 ? 0 : 1;
        Arrays.sort(c);
        int h = 0;
        for (int i = 0; i < c.length; i++) {
            int remain = c.length - i;
            if (remain >= c[i])
                h = c[i];
        }
        return h == 0 && c[c.length - 1] > 0 ? c.length : 0;
    }

    static int hIndex2(int[] c) {
        if (c.length == 1) return c[0] == 0 ? 0 : 1;
        Arrays.sort(c);
        int h = 0;
        for (int i = 0; i < c.length; i++) {
            int remain = c.length - i;
            if (i <= remain && c[i] <= remain) h = c[i];
        }
        return h;
    }

    static int hIndex1(int[] citations) {
        int sum = 0;
        for(int n: citations) sum += n;
        return sum / citations.length;
    }
}
