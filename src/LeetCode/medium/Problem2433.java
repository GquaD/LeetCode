package LeetCode.medium;

import java.util.Arrays;

public class Problem2433 {
    //https://leetcode.com/problems/find-the-original-array-of-prefix-xor/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArray(new int[]{5,2,0,3,1})));
        System.out.println(Arrays.toString(findArray(new int[]{13})));
    }

    //20 mins
    //https://leetcode.com/problems/find-the-original-array-of-prefix-xor/solutions/2681743/java-100-faster-100-memory-effective/
    //Runtime
    //8 ms
    //Beats
    //100%
    //Memory
    //95.4 MB
    //Beats
    //100%
    static int[] findArray(int[] pref) {
        int prev = pref[0], memo = prev;
        for (int i = 1; i < pref.length; i++) {
            memo = pref[i];
            pref[i] = prev ^ pref[i];
            prev = memo;
        }
        return pref;
    }
}
