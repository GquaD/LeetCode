package LeetCode.medium;

import java.util.*;

public class Problem3221 {
    //https://leetcode.com/problems/maximum-array-hopping-score-ii/

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{4,5,2,8,9,1,3}));
    }

    //https://leetcode.com/problems/maximum-array-hopping-score-ii/solutions/5500747/java-from-o-nlogn-to-o-n-solution/
    //10min
    //Runtime
    //7
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //61.12
    //MB
    //Beats
    //100.00%
    public static long maxScore(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i];
            if (val > max) {
                stack.push(new Pair(val, i));
                max = val;
            }
        }
        long sum = 0;
        int idx = 0;
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            sum += (p.idx - idx) * 1L * p.val;
            idx = p.idx;
        }
        return sum;
    }


    //
    //10min
    //Runtime
    //140
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //62.29
    //MB
    //Beats
    //100.00%
    public long maxScore1(int[] nums) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair(nums[i], i));
        }
        Collections.sort(list, (a, b) -> b.val == a.val ? b.idx - a.idx : b.val - a.val);
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (idx == list.size() - 1) break;
            Pair p = list.get(i);
            if (p.idx > idx) {
                sum += (p.idx - idx) * 1L * p.val;
                idx = p.idx;
            }
        }
        return sum;
    }
    static class Pair {
        int val, idx;

        public Pair (int v, int i) {
            val = v;
            idx = i;
        }
    }

}

