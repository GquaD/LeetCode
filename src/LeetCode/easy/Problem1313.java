package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1313 {
    //https://leetcode.com/problems/decompress-run-length-encoded-list/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 1, 2, 3})));
    }

    //Runtime: 1 ms, faster than 98.40% of Java online submissions for Decompress Run-Length Encoded List.
    //Memory Usage: 42.9 MB, less than 93.86% of Java online submissions for Decompress Run-Length Encoded List.
    static int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }

        int[] result = new int[size];
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                result[count++] = nums[i + 1];
            }
        }
        return result;
    }

    //Runtime: 5 ms, faster than 43.25% of Java online submissions for Decompress Run-Length Encoded List.
    //Memory Usage: 49.2 MB, less than 11.53% of Java online submissions for Decompress Run-Length Encoded List.
    static int[] decompressRLElist1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
