package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1007 {
    //https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{1,2,1,1,1,2,2,2}, new int[]{2,1,2,2,2,2,2,2}));
    }

    //https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/solutions/3623411/java-greedy-o-n-solution/
    //15-20 min
    //Runtime
    //6 ms
    //Beats
    //40.14%
    //Memory
    //49.1 MB
    //Beats
    //88.3%
    static int minDominoRotations(int[] tops, int[] bottoms) {
        int[] t = new int[7], b = new int[7];
        for (int i = 0; i < tops.length; i++) {
            t[tops[i]]++;
            b[bottoms[i]]++;
        }
        boolean hasEnough = false;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            if (t[i] + b[i] >= tops.length) {
                hasEnough = true;
                nums.add(i);
            }
        }
        if (!hasEnough) return -1;
        int count = tops.length;
        for (int n : nums) {
            int ct = 0, cb = 0;
            boolean broken = false;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != n && bottoms[i] != n) {
                    broken = true;
                    break;
                } else {
                    if (tops[i] == n) {
                        if (bottoms[i] != n) {
                            cb++;
                        }
                    } else {
                        ct++;
                    }
                }
            }
            if (broken) continue;
            count = Math.min(count, Math.min(ct, cb));
        }
        return count == tops.length ? -1 : count;
    }
}
