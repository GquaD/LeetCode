package LeetCode.easy;

import java.util.Arrays;

public class Problem1046 {
    //https://leetcode.com/problems/last-stone-weight/
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{1,3}));
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeight(new int[]{1}));
    }
    //10 mins

    //Runtime: 1 ms, faster than 99.71% of Java online submissions for Last Stone Weight.
    //Memory Usage: 41.1 MB, less than 81.02% of Java online submissions for Last Stone Weight.
    static int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 1) return stones[0];
        int g1 = 0, g2 = 0;
        while (g1 != -1 && g2 != -1) {
            int[] maxes = find2MaxAndIndices(stones);
            g1 = maxes[0];
            g2 = maxes[2];
            stones[maxes[3]] = Math.abs(g1 - g2); //since 0 will not be given according to problem
            stones[maxes[1]] = -1;
        }
        if (g1 == -1 && g2 == -1) return 0;
        else return Math.max(g1, g2);
    }

    static int[] find2MaxAndIndices(int[] nums) {
        int max = -2, max2 = -2, maxIndex = 0, max2Index = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (max < n) {
                max2 = max;
                max2Index = maxIndex;
                max = n;
                maxIndex = i;
            } else if (max2 < n) {
                max2 = n;
                max2Index = i;
            }
        }
        int[] result = new int[]{max, maxIndex, max2, max2Index}; //1 max, 2 index, 3 second max, 4 its index
        return result;
    }

    //20 mins
    //Runtime: 2 ms, faster than 82.00% of Java online submissions for Last Stone Weight.
    //Memory Usage: 42.4 MB, less than 6.53% of Java online submissions for Last Stone Weight.
    static int lastStoneWeight1(int[] stones) {
        int len = stones.length;
        if (len == 1) return stones[0];
        while (true) {
            Arrays.sort(stones);
            if (stones[len - 2] == -1) {
                break;
            }
            int g1 = stones[len - 1];
            int g2 = stones[len - 2];
            stones[len - 2] = Math.abs(g1 - g2); //since 0 will not be given according to problem
            stones[len - 1] = -1;

        }
        return stones[len - 1];
    }
}
