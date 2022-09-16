package LeetCode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1389 {
    //https://leetcode.com/problems/create-target-array-in-the-given-order/
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            index[i] = list.get(i);
        }
        return index;
    }
}
