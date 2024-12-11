package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2838 {

    //https://leetcode.com/problems/maximum-coins-heroes-can-collect/solutions/6135748/java-sorting-binary-search-solution/
    //20min
    //Runtime
    //49
    //ms
    //Beats
    //95.70%
    //Analyze Complexity
    //Memory
    //58.72
    //MB
    //Beats
    //55.64%
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            list.add(new Pair(monsters[i], (long)coins[i]));
        }
        Collections.sort(list, (a, b) -> a.monster - b.monster);
        long sum = 0;
        long[] coins1 = new long[coins.length];
        int[] m = new int[monsters.length];
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            sum += p.coin;
            coins1[i] = sum;
            m[i] = p.monster;
        }
        long[] res = new long[heroes.length];
        for (int i = 0; i < heroes.length; i++) {
            int idx = Arrays.binarySearch(m, heroes[i]);
            idx = idx < 0 ? - idx - 1 : idx;
            while (idx < m.length && heroes[i] >= m[idx]) {
                idx++;
            }
            if (idx > 0) {
                res[i] = coins1[idx - 1];
            }
        }
        return res;
    }

    class Pair {
        int monster;
        long coin;

        public Pair (int m, long c) {
            monster = m;
            coin = c;
        }
    }
}
