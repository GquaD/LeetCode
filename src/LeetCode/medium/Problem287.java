package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem287 {
    //https://leetcode.com/problems/find-the-duplicate-number/description/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //4 ms
    //Beats
    //88.12%
    //Memory
    //59.8 MB
    //Beats
    //75.21%

    static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    //2 min
    //Runtime
    //22 ms
    //Beats
    //38.37%
    //Memory
    //55.1 MB
    //Beats
    //99.35%
    static int findDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return n;
            else set.add(n);
        }
        return nums[0];
    }

    //20 min
    //Runtime
    //38 ms
    //Beats
    //18.36%
    //Memory
    //60 MB
    //Beats
    //59.25%
    static int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) if (nums[i] == nums[i - 1]) return nums[i];
        return nums[0];
    }

    static int findDuplicate1(int[] nums) {
        int arithSum = ((1 + nums.length - 1) * (nums.length - 1)) / 2, runningSum = 0;
        for (int n : nums) runningSum += n;
        return arithSum - runningSum;
    }
}
