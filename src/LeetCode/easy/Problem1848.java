package LeetCode.easy;

public class Problem1848 {
    //https://leetcode.com/problems/minimum-distance-to-the-target-element
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-distance-to-the-target-element/solutions/6306742/java-0ms-100-faster-solution-by-tbekpro-xfg6/
    //10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.44
    //MB
    //Beats
    //26.98%
    public int getMinDistance(int[] nums, int target, int start) {
        int l = start, r = start, max = Integer.MAX_VALUE;
        boolean foundl = false, foundr = false;
        for (; r < nums.length; r++) {
            if (nums[r] == target) {
                foundr = true;
                break;
            }
        }
        for (; l >= 0; l--) {
            if (nums[l] == target) {
                foundl = true;
                break;
            }
        }

        if (!foundl) l = max;
        if (!foundr) r = max;

        return Math.min(Math.abs(l - start), Math.abs(r - start));
    }
}
