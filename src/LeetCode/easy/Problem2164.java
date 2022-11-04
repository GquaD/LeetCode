package LeetCode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2164 {
    //https://leetcode.com/problems/sort-even-and-odd-indices-independently/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{5,39,33,5,12,27,20,45,14,25,32,33,30,30,9,14,44,15,21})));
    }

    //https://leetcode.com/problems/sort-even-and-odd-indices-independently/solutions/2776431/java-average-solution-o-2n-n-log-n/
    //10-15 mins
    //Runtime
    //13 ms
    //Beats
    //16.58%
    //Memory
    //45.2 MB
    //Beats
    //19.95%
    static int[] sortEvenOdd(int[] nums) {
        int[] even = new int[nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1];
        Integer[] odd = new Integer[nums.length / 2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[count] = nums[i];
            } else {
                odd[count++] = nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd, Comparator.reverseOrder());
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even[count];
            } else {
                nums[i] = odd[count++];
            }
        }
        return nums;
    }
}
