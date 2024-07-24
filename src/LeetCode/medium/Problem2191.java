package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem2191 {
    //https://leetcode.com/problems/sort-the-jumbled-numbers

    //https://leetcode.com/problems/sort-the-jumbled-numbers/solutions/5527929/java-using-heap/
    //10-15min
    //Runtime
    //185
    //ms
    //Beats
    //58.82%
    //Analyze Complexity
    //Memory
    //55.62
    //MB
    //Beats
    //41.18%
    class Solution {
        StringBuilder sb;
        public int[] sortJumbled(int[] mapping, int[] nums) {
            sb = new StringBuilder();
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.newVal == b.newVal ? a.idx - b.idx : a.newVal - b.newVal);
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i], map = map(mapping, val);
                pq.offer(new Pair(i, val, map));
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = pq.poll().val;
            }
            return nums;
        }

        private int map(int[] m, int val) {
            if (val == 0) {
                sb.append(m[0]);
            } else {
                while (val > 0) {
                    sb.append(m[val % 10]);
                    val /= 10;
                }
            }
            int res = Integer.parseInt(sb.reverse().toString());
            sb.setLength(0);
            return res;
        }
    }

    class Pair {
        int idx, val, newVal;

        public Pair (int i, int v, int nv) {
            idx = i;
            val = v;
            newVal = nv;
        }
    }
}
