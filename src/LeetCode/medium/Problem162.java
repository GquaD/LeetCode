package LeetCode.medium;

public class Problem162 {
    //https://leetcode.com/problems/find-peak-element/
    public static void main(String[] args) {

    }

    //my solution is O(N). Description asked to write O(log N) solution
    //10-15 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.7 MB
    //Beats
    //58.6%
    static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return i;
        }
        return -1;
    }

    static int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
