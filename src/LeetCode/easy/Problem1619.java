package LeetCode.easy;

import java.util.Arrays;

public class Problem1619 {
    //https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
    public static void main(String[] args) {
        System.out.println(trimMean(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}));
        System.out.println(trimMean(new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0}));
        System.out.println(trimMean(new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4}));
    }

    //5 mins
    //Runtime: 4 ms, faster than 68.87% of Java online submissions for Mean of Array After Removing Some Elements.
    //Memory Usage: 44.1 MB, less than 46.03% of Java online submissions for Mean of Array After Removing Some Elements.
    static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int percent5 = arr.length / 20;
        int sum = 0;
        for (int i = percent5; i < arr.length - percent5; i++) {
            sum += arr[i];
        }
        return (sum * 1.0) / (arr.length - percent5 - percent5);
    }
}
