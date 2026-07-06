package LeetCode.easy;

public class Problem1995 {
    //5min

    //Runtime
    //25
    //ms
    //Beats
    //9.40%
    //Memory
    //43.43
    //MB
    //Beats
    //52.29%
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 3; i < nums.length; i++) {
            for (int j = 0; j < i - 2; j++) {
                for (int k = j + 1; k < i - 1; k++) {
                    if (k == j) continue;
                    for (int l = k + 1; l < i; l++) {
                        if (l == k || l == j) continue;
                        if (nums[i] == nums[j] + nums[k] + nums[l]) count++;
                    }
                }
            }
        }

        return count;
    }
}
