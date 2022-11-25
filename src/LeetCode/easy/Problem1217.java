package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem1217 {
    //https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{6,4,7,8,2,10,2,7,9,7}));
        System.out.println(minCostToMoveChips(new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/solutions/2846780/java-o-n-100-faster-5-lines/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42 MB
    //Beats
    //25%
    static int minCostToMoveChips(int[] position) {
        int countEven = 0, countOdd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) countEven++;
            else countOdd++;
        }
        return Math.min(countOdd, countEven);
    }

    static int minCostToMoveChips1(int[] position) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, posMax = 0;
        for (int i = 0; i < position.length; i++) {
            int toPut = 1;
            if (map.containsKey(position[i])) {
                toPut = map.get(position[i]) + 1;
                map.put(position[i], toPut);
            } else {
                map.put(position[i], toPut);
            }
            if (max < toPut) {
                max = toPut;
                posMax = position[i];
            }
        }
        int count = 0;
        for (int p : map.keySet()) {
            if (p != posMax && Math.abs(posMax - p) % 2 != 0) {
                count += map.get(p);
            }
        }
        return count;
    }
}
