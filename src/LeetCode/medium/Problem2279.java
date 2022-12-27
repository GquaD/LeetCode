package LeetCode.medium;

import java.util.*;

public class Problem2279 {
    //https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
    public static void main(String[] args) {
        System.out.println(maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
        System.out.println(maximumBags(new int[]{10,2,2}, new int[]{2,2,0}, 100));
    }

    //https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/solutions/2956768/java-from-16-to-99-time/
    //5 min
    //Runtime
    //14 ms
    //Beats
    //99.11%
    //Memory
    //53.3 MB
    //Beats
    //80.53%
    static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < rocks.length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int count = 0;
        for (int n : capacity) {
            if (additionalRocks > 0) {
                if (additionalRocks >= n) {
                    count++;
                    additionalRocks -= n;
                }
            } else break;
        }
        return count;
    }

    //15 min
    //Runtime
    //115 ms
    //Beats
    //16.52%
    //Memory
    //50.3 MB
    //Beats
    //98.52%
    //2N + NlogN
    static int maximumBags1(int[] capacity, int[] rocks, int additionalRocks) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < rocks.length; i++) {
            Pair p = new Pair(capacity[i], rocks[i]);
            list.add(p);
        }
        Collections.sort(list, Comparator.comparing(p -> p.capacity - p.rocks));
        int count = 0;
        for (Pair p : list) {
            if (additionalRocks > 0) {
                int diff = p.capacity - p.rocks;
                if (additionalRocks >= diff) {
                    count++;
                    additionalRocks -= diff;
                }
            } else break;
        }
        return count;
    }

    static class Pair {
        int capacity, rocks;

        public Pair(int capacity, int rocks) {
            this.capacity = capacity;
            this.rocks = rocks;
        }
    }
}
