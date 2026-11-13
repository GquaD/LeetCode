package LeetCode.medium;

import java.util.*;

public class Problem4101 {
    //15min
    //Runtime
    //26
    //ms
    //Beats
    //73.68%
    //Memory
    //115.86
    //MB
    //Beats
    //39.47%
    public int[][] findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();

        for (int n: nums) {
            if (lower <= n && n <= upper) {
                if (n - 1 >= lower) list.add(new int[]{lower, n - 1});
                lower = n + 1;
            }
        }

        if (lower <= upper) list.add(new int[]{lower, upper});

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }
}
