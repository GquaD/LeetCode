package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1375 {
    //https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/
    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{3,2,4,1,5}));
        System.out.println(numTimesAllBlue(new int[]{1,2,3,4,5}));
        System.out.println(numTimesAllBlue(new int[]{4,1,2,3}));
    }

    //https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/solutions/3718296/java-from-16-to-100-faster-with-and-without-hashset/
    //5 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //49.1 MB
    //Beats
    //78.66%
    static int numTimesAllBlue(int[] flips) {
        int l = 0, c = 0, res = 0;
        for (int i = 0; i < flips.length; i++) {
            int curr = flips[i];
            if (l < curr) l = curr;
            if (++c >= l) res++;
        }
        return res;
    }

    //
    //5min
    //Runtime
    //14 ms
    //Beats
    //15.85%
    //Memory
    //54.5 MB
    //Beats
    //5.49%
    static int numTimesAllBlue1(int[] flips) {
        int l = 0, count = 0;
        Set<Integer> setIndOfOne = new HashSet<>();
        for (int i = 0; i < flips.length; i++) {
            int curr = flips[i];
            setIndOfOne.add(curr);
            if (l < curr) l = curr;
            if (setIndOfOne.size() == l) count++;
        }
        return count;
    }
}
