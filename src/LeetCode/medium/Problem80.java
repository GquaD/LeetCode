package LeetCode.medium;

public class Problem80 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solutions/2852511/java-o-n-1ms-solution/
    //20min
    //Runtime
    //1 ms
    //Beats
    //85.51%
    //Memory
    //44.9 MB
    //Beats
    //40.45%
    static int removeDuplicates(int[] nums) {
        int prev = nums[0], count = 1, idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            } else {
                count = 1;
                prev = nums[i];
            }
            if (count >= 3) {
                continue;
            }
            nums[idx++] = prev;
        }
        return idx;
    }
}
