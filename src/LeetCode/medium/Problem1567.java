package LeetCode.medium;
import java.util.*;

public class Problem1567 {
    //https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{0,1,-2,-3,-4}));
        System.out.println(getMaxLen(new int[]{2,-1}));
        System.out.println(getMaxLen(new int[]{0,0,0,0}));
        System.out.println(getMaxLen(new int[]{-1}));
        System.out.println(getMaxLen(new int[]{-1,2}));
        System.out.println(getMaxLen(new int[]{0,1,-2,-3,-4,0,1,-2,2,-3,-4}));
        System.out.println(getMaxLen(new int[]{0,1,-2,-3,-4,0,1,-2,-3,-4}));
    }

    //nnn
    //Runtime
    //3
    //ms
    //Beats
    //99.03%
    //of users with Java
    //Memory
    //59.24
    //MB
    //Beats
    //78.67%
    //of users with Java

    static int getMaxLen(int[] nums) {
        int pos = 0, neg = 0, res = 0;
        for (int n : nums) {
            if (n == 0) {
                pos = neg = 0;
            } else if (n > 0) {
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            } else {
                int t = pos;
                pos = neg == 0 ? 0 : neg + 1;
                neg = t + 1;
            }
            res = Math.max(res, pos);
        }
        return res;
    }

    static int getMaxLen1(int[] nums) {
        List<Integer> list0 = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                list0.add(i);
        }
        if (list0.size() == 0) {
            int neg = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) neg++;
            }
            if (neg % 2 == 0) return nums.length;
            else {
                int l = 0, r = nums.length - 1;
                while (nums[l++] > 0);
                while (nums[r--] > 0);
                return Math.max(nums.length - l, r + 1);
            }
        } else {
            int prev = 0;
            for (int i = 0; i < list0.size(); i++) {
                int next = list0.get(i);
                if (next - prev == 1) {
                    prev = next;
                    continue;
                }
                int pos = 0, neg = 0;
                for (int j = prev; j < next; j++) {
                    if (nums[j] > 0) pos++;
                    else if(nums[j] < 0) neg++;
                }
                if (neg % 2 == 0) max = Math.max(max, next - prev);
                else {
                    int l = prev, r = next;
                    while (nums[l++] > 0);
                    while (nums[r--] > 0);
                    int temp = Math.max(next - l - 1, r - prev - 1);
                    max = Math.max(temp, max);
                }
                prev = next;
            }
            int next = nums.length;
            int pos = 0, neg = 0;
            for (int j = prev; j < next; j++) {
                if (nums[j] > 0) pos++;
                else if(nums[j] < 0) neg++;
            }
            if (next - prev == 1) return max;
            if (neg % 2 == 0) max = Math.max(max, next - prev);
            else {
                int l = prev, r = next - 1;
                while (nums[l++] > 0);
                while (nums[r--] > 0);
                int temp = Math.max(next - l - 1, r - prev - 1);
                max = Math.max(temp, max);
            }
        }
        return max;
    }
}
