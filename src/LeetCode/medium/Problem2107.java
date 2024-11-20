package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2107 {
    //https://leetcode.com/problems/number-of-unique-flavors-after-sharing-k-candies
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-unique-flavors-after-sharing-k-candies/solutions/6065312/java-unusual-sliding-window/
    //15-20min
    //Runtime
    //36
    //ms
    //Beats
    //79.27%
    //Analyze Complexity
    //Memory
    //54.82
    //MB
    //Beats
    //99.82%
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = k; i < candies.length; i++) {
            int c = candies[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = map.size();
        for (int i = k; i < candies.length; i++) {
            int add = candies[i - k], skip = candies[i];
            map.put(add, map.getOrDefault(add, 0) + 1);
            int freq = map.get(skip);
            if (freq > 1) map.put(skip, freq - 1);
            else map.remove(skip);
            max = Math.max(max, map.size());
        }
        return max;
    }
}
