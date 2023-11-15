package LeetCode.medium;

public class Problem1764 {
    //https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/
    public static void main(String[] args) {
        System.out.println(canChoose(new int[][]{{21,22,21,22,21,30}}, new int[]{21,22,21,22,21,22,21,30}));
        System.out.println(canChoose(new int[][]{{1,-1,-1}, {3,-2,0}}, new int[]{1,-1,0,1,-1,-1,3,-2,0}));
        System.out.println(canChoose(new int[][]{{10,-2}, {1,2,3,4}}, new int[]{1,2,3,4,10,-2}));
        System.out.println(canChoose(new int[][]{{1,2,3}, {3,4}}, new int[]{7,7,1,2,3,4,7,7}));
    }

    //https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/solutions/4291204/java-o-n-solution/
    //20-30 min
    //Runtime
    //1 ms
    //Beats
    //72.60%
    //Memory
    //43.7 MB
    //Beats
    //9.59%
    static boolean canChoose(int[][] groups, int[] nums) {
        int g = 0, gIdx = 0, e = groups.length - 1, eIdx = groups[groups.length - 1].length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (g >= groups.length) break;
            if (nums[i] == groups[g][gIdx]) {
                gIdx++;
                if (gIdx >= groups[g].length) {
                    g++;
                    gIdx = 0;
                }
            } else {
                if (gIdx != 0) i--;
                gIdx = 0;
            }
        }

        if (g > groups.length - 1) return true;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == groups[e][eIdx]) {
                eIdx--;
                if (eIdx < 0) {
                    e--;
                    if (e < 0) break;

                    eIdx = groups[e].length - 1;
                }
            } else {
                if (eIdx != groups[e].length - 1) i++;
                eIdx = groups[e].length - 1;
            }
        }

        return e < 0;
    }
}
