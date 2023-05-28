package LeetCode.medium;

import java.util.*;

public class Problem611 {
    //https://leetcode.com/problems/valid-triangle-number/
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(triangleNumber(new int[]{4, 2, 3, 4}));
    }

    //nnnn
    //Runtime
    //33 ms
    //Beats
    //54.17%
    //Memory
    //43.5 MB
    //Beats
    //5.1%
    static int triangleNumber(int[] nums) {
        int res = 0;
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) res += (right-- - left);
                else left++;
            }
        }
        return res;
    }

    //Time Limit Exceeded
    //208 / 241
    static int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> setIdx = new HashSet<>(), setRes = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            backtrack(i, new ArrayList<>(), nums, setIdx);
        }
        int count = 0;
        for (List<Integer> l : setIdx) {
            int a = nums[l.get(0)], b = nums[l.get(1)], c = nums[l.get(2)];
            int max = Math.max(a, Math.max(b, c));
            if (max < a + b + c - max) count++;
        }
        return count;
    }

    private static void backtrack(int i, ArrayList<Integer> l, int[] nums, Set<List<Integer>> set) {
        if (i >= nums.length) return;

        l.add(i);
        if (l.size() == 3) {
            set.add(new ArrayList<>(l));
            l.remove(l.size() - 1);
            return;
        }
        for (int j = i + 1; j < nums.length; j++) {
            backtrack(j, l, nums, set);
        }
        if (l.size() > 0) l.remove(l.size() - 1);
    }
}
