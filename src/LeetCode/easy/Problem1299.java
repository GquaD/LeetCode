package LeetCode.easy;

import java.util.Arrays;

public class Problem1299 {
    //https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17,18,5,4,6,1})));
        System.out.println(Arrays.toString(replaceElements(new int[]{400})));
    }

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
    //Memory Usage: 54.5 MB, less than 36.94% of Java online submissions for Replace Elements with Greatest Element on Right Side.
    static int[] replaceElements(int[] arr) {
        int lastIndex = arr.length - 1;
        int max = arr[lastIndex];
        arr[lastIndex] = -1;
        for (int i = lastIndex - 1; i >= 0; i--) {
            int temp = max;
            if (max < arr[i]) {
                max = arr[i];
            }
            arr[i] = temp;
        }
        return arr;
    }
}
