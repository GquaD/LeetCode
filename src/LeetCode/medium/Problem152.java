package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem152 {
    //https://leetcode.com/problems/maximum-product-subarray/
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-5,-2,-4,3}));//24
        System.out.println(maxProduct(new int[]{-3,0,1,-2}));//1
        System.out.println(maxProduct(new int[]{-2, 3, -4}));//24
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }

    //Runtime
    //1 ms
    //Beats
    //92.52%
    //Memory
    //42.9 MB
    //Beats
    //44.39%
    static int maxProduct(int[] nums) {
        int len = nums.length, res = nums[0], left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[len - 1 - i];
            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }

    static int maxProduct1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int product = nums[0], max = Integer.MIN_VALUE, productInt = product, countMinus = 0;
        Queue<Integer> queueMinus = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < 0) {
                countMinus++;
                queueMinus.offer(curr);
            }

            if (curr == 0) {
                productInt = 1;
                countMinus = 0;
                queueMinus.clear();
                product = Math.max(product, 0);
                continue;
            }
            productInt *= curr;
            if (productInt < 0 && countMinus > 2) {
                productInt /= queueMinus.poll();
            }
            product = Math.max(product * curr, Math.max(curr, productInt));
            max = Math.max(max, product);
        }
        return Math.max(product, max);
    }
}
