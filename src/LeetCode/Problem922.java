package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem922 {
    //https://leetcode.com/problems/sort-array-by-parity-ii/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2, 3})));
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{1, 3, 5, 6, 4, 2})));
    }

    //Runtime: 9 ms, faster than 14.45% of Java online submissions for Sort Array By Parity II.
    //Memory Usage: 55.8 MB, less than 5.35% of Java online submissions for Sort Array By Parity II.
    static int[] sortArrayByParityII(int[] nums) {
        Queue<Integer> even = new LinkedList<>();
        Queue<Integer> odd = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp % 2 == 0) {
                even.add(temp);
            } else {
                odd.add(temp);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even.poll();
            } else {
                nums[i] = odd.poll();
            }
        }
        return nums;
    }
}
