package LeetCode.easy;

public class Problem747 {
    //https://leetcode.com/problems/largest-number-at-least-twice-of-others/
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{0,0,3,2}));
    }

    //https://leetcode.com/problems/largest-number-at-least-twice-of-others/solutions/3963673/java-o-n-100-faster-1-loop/
    //5-10min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.7 MB
    //Beats
    //28.96%
    static int dominantIndex(int[] nums) {
        int max = 0, idxMax = 0, maxPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                maxPrev = max;
                max = nums[i];
                idxMax = i;
            } else if (maxPrev < nums[i]) {
                maxPrev = nums[i];
            }
        }
        return maxPrev * 2 <= max ? idxMax : -1;
    }
}
