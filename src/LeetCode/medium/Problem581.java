package LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem581 {
    //https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solutions/3623271/java-o-nlogn-using-priorityqueues-explained/
    //5-10 min
    //Runtime
    //26 ms
    //Beats
    //13.22%
    //Memory
    //44.8 MB
    //Beats
    //9.53%
    static int findUnsortedSubarray(int[] nums) {
        PriorityQueue<Integer> pqInc = new PriorityQueue<>(), pqDec = new PriorityQueue<>(Comparator.reverseOrder());
        pqInc.offer(nums[0]);
        pqDec.offer(nums[0]);
        boolean inc = true, decr = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) inc = false;
            if (nums[i - 1] < nums[i]) decr = false;
            pqInc.offer(nums[i]);
            pqDec.offer(nums[i]);
        }
        if (inc) return 0;
        if (decr) return nums.length;
        int a = 0, b = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (pqInc.poll() != nums[i]) {
                a = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (pqDec.poll() != nums[i]) {
                b = i;
                break;
            }
        }
        return b - a + 1;
    }
}
