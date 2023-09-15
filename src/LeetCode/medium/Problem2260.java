package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2260 {
    //https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{70, 37, 70, 41, 1, 62, 71, 49, 38, 50, 29, 76, 29, 41, 22, 66, 88, 18, 85, 53}));
        System.out.println(minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(minimumCardPickup(new int[]{1, 0, 5, 3}));
    }

    //https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/solutions/4047771/java-o-n-simple-map-solution/
    //10-15min
    //Runtime
    //44 ms
    //Beats
    //62.56%
    //Memory
    //58.5 MB
    //Beats
    //39.59%
    static int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            Integer idx = map.get(cards[i]);
            if (idx != null) res = Math.min(res, i - idx + 1);
            map.put(cards[i], i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
