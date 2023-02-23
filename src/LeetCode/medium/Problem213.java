package LeetCode.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class Problem213 {
    //https://leetcode.com/problems/house-robber-ii/
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,7,9,4}));
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    //nnnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.7 MB
    //Beats
    //6.7%
    static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev = nums[0], prev2 = 0, curr;
        for (int i = 1; i < nums.length - 1; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        int ans = prev;
        prev = nums[1];
        prev2 = 0;
        for (int i = 2; i < nums.length; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr ;
        }
        return Math.max(ans, prev);
    }
    //30 min
    //57 / 75
    static int rob1(int[] nums) {
        //val -> idx

        int sumEven = 0, sumOdd = 0;
        if (nums.length > 3) {
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) sumEven += nums[i];
                else sumOdd += nums[i];
            }
        }
        if (nums.length % 2 != 0) {
            sumEven -= nums[nums.length - 1];
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
        for (int i = 0; i < nums.length; i++)
            pq.offer(new Pair(nums[i], i));
        Set<Integer> setIndices = new HashSet<>();
        int sum = 0;
        while (!pq.isEmpty()) {
            Pair pairMax = pq.poll();
            int idxLeft = pairMax.getIdx() == 0 ? nums.length - 1 : pairMax.getIdx() - 1;
            int idxRight = pairMax.getIdx() == nums.length - 1 ? 0 : pairMax.getIdx() + 1;
            if (!setIndices.contains(pairMax.getIdx()) && !setIndices.contains(idxLeft)
                && !setIndices.contains(idxRight)) {
                sum += pairMax.getVal();
                setIndices.add(pairMax.getIdx());
            }
        }
        return Math.max(Math.max(sumEven, sumOdd), sum);
    }

    static class Pair {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }
}
