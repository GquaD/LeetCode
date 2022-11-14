package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem228 {
    //https://leetcode.com/problems/summary-ranges/
    public static void main(String[] args) {
        LeetCodeUtils.printList(summaryRanges(new int[]{0,1,2,4,5,7}));
        LeetCodeUtils.printList(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }


    //20-30 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //56.21%
    static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int start = nums[0], end = nums[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (start == end) {
                    sb.append(start);
                    list.add(sb.toString());
                } else {
                    sb.append(start).append("->").append(end);
                    list.add(sb.toString());
                }
                sb.setLength(0);
                start = nums[i + 1];
                end = nums[i + 1];
            } else {
                end = nums[i + 1];
            }
        }
        if (start == end) {
            sb.append(start);
            list.add(sb.toString());
        } else {
            sb.append(start).append("->").append(end);
            list.add(sb.toString());
        }
        return list;
    }
}
