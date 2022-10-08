package LeetCode.easy;

import java.util.Arrays;

public class Problem66 {
    //https://leetcode.com/problems/plus-one/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
    }

    //https://leetcode.com/problems/plus-one/solutions/2675965/java-100-faster-solution/
    //10-15mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.2 MB
    //Beats
    //67.96%
    static int[] plusOne(int[] d) {
        int memo = 1;
        for (int i = d.length - 1; i >= 0; i--) {
            if (d[i] < 9 && memo != 0) {
                d[i]++;
                memo--;
                break;
            } else if (d[i] == 9) {
                d[i] = 0;
            }
        }
        if (memo != 0) {
            int[] res = new int[d.length + 1];
            res[0] = memo;
            for (int i = 1; i <= d.length; i++) {
                res[i] = d[i - 1];
            }
            return res;
        }
        return d;
    }
}
