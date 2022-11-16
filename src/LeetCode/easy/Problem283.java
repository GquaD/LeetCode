package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Problem283 {
    //https://leetcode.com/problems/move-zeroes/
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{2,1,0,3,12});
    }

    //https://leetcode.com/problems/move-zeroes/solutions/2819885/java-from-30ms-to-3ms-o-n-2-solutions/
    //Runtime
    //3 ms
    //Beats
    //72.23%
    //Memory
    //54.2 MB
    //Beats
    //78.44%
    static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[idx++] = temp;
            }
        }
        System.out.println("");
    }

    //Runtime
    //30 ms
    //Beats
    //11.75%
    //Memory
    //55.2 MB
    //Beats
    //12.66%
    static void moveZeroes1(int[] nums) {
        Queue<Integer> idxZero = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                idxZero.add(i);
            } else {
                if (!idxZero.isEmpty()) {
                    nums[idxZero.poll()] = nums[i];
                    nums[i] = 0;
                    idxZero.add(i);
                }
            }
        }
        System.out.println("h");
    }
}
