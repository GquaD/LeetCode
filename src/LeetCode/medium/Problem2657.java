package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem2657 {
    //https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4})));
    }


    //https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/solutions/3476155/java-solution-using-hashset/
    //5 min
    //Runtime
    //10 ms
    //Beats
    //47.99%
    //Memory
    //43.8 MB
    //Beats
    //6.84%
    static int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            setA.add(A[i]);
            for (int j = 0; j <= i; j++) if (setA.contains(B[j])) res[i]++;
        }
        return res;
    }
}
