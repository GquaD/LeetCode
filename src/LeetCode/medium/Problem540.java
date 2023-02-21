package LeetCode.medium;

public class Problem540 {
    //https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }


    //https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/3213044/java-o-logn-time-o-1-space-100-faster-solution/
    //15 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //48.1 MB
    //Beats
    //72.85%
    static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2, midL = Math.max(0, mid - 1), midR = Math.min(nums.length, mid + 1);
            if (nums[mid] != nums[midL] && nums[mid] != nums[midR]) return nums[mid];
            if (mid % 2 == 0) {
                if (nums[mid] == nums[midL]) right = mid; //number is on the left since mid == mid - 1, there is odd number of elements
                else if (nums[mid] == nums[midR]) left = mid;
            } else {
                if (nums[mid] == nums[midL]) left = mid;
                else if (nums[mid] == nums[midR]) right = mid;
            }

        }
        return nums[nums.length - 1];
    }

    //5 min
    //Runtime
    //1 ms
    //Beats
    //30.40%
    //Memory
    //48.6 MB
    //Beats
    //17.19%
    static int singleNonDuplicate1(int[] nums) {
        for (int i = 1; i < nums.length - 1; i += 2) if (nums[i - 1] != nums[i]) return nums[i - 1];
        return nums[nums.length - 1];
    }
}
