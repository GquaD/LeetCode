package LeetCode.medium;

import java.util.Arrays;
import java.util.Collections;

public class Problem167 {
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3}, 5)));
    }

    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/3057343/java-4-lines-o-nlogn-solution/
    //5-10min
    //Runtime
    //2 ms
    //Beats
    //59.53%
    //Memory
    //44.9 MB
    //Beats
    //92.29%
    static int[] twoSum(int[] n, int target) {
        for (int i = 0; i < n.length; i++) {
            int idx = Arrays.binarySearch(n, target - n[i]);
            if (idx > -1 && idx != i) return i > idx ? new int[]{idx+1, i+1} : new int[]{i+1, idx+1};
        }
        return null;
    }

    static int[] twoSum1(int[] n, int target) {
        int len = n.length % 2 == 0 ? n.length / 2 : (n.length / 2) + 1;
        for (int i = 0; i < len; i++) {
            int idx = Arrays.binarySearch(n, target - n[i]);
            if (idx > -1 && idx != i) return i > idx ? new int[]{idx+1, i+1} : new int[]{i+1, idx+1};
            int idx2 = n.length - i - 1;
            idx = Arrays.binarySearch(n, target - n[idx2]);
            if (idx > -1 && idx != idx2) return idx2 > idx ? new int[]{idx+1, idx2+1} : new int[]{idx2+1, idx+1};
        }
        return null;
    }
}
