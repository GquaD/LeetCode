package LeetCode.easy;

import java.util.Arrays;

public class Problem1652 {
    //https://leetcode.com/problems/defuse-the-bomb/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[]{2,4,9,3}, -2)));
    }

    //10 min
    //Runtime
    //1 ms
    //Beats
    //76.81%
    //Memory
    //42.6 MB
    //Beats
    //41.74%
    static int[] decrypt(int[] code, int k) {
        if (code.length == 1) {
            if (k != 0) return code;
            else return new int[]{0};
        }
        if (k == 0) return new int[code.length];
        else if (k > 0) {
            int[] arr = new int[code.length];
            int[] copytwice = new int[code.length * 2];
            for (int i = 0; i < copytwice.length; i++) {
                copytwice[i] = arr[i % arr.length];
            }
            for (int i = 0; i < code.length; i++) {
                for (int j = i + 1; j <= i + k; j++) {
                    arr[i] += copytwice[j];
                }
            }
            return arr;
        } else {
            int[] arr = new int[code.length];
            int[] copytwice = new int[code.length * 2];
            for (int i = 0; i < copytwice.length; i++) {
                copytwice[i] = code[i % arr.length];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = i + arr.length - 1; j >= i + arr.length + k; j--) {
                    arr[i] += copytwice[j];
                }
            }
            return arr;
        }
    }
}
