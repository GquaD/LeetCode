package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1287 {
    //https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1,1,1,1,1,1,2,3,4,5,6,7,8,9,10,11,12,12,12,12}));
    }

    //10 min
    //Runtime
    //8 ms
    //Beats
    //35.19%
    //Memory
    //42.6 MB
    //Beats
    //58.8%
    static int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if (!map.containsKey(n)) map.put(n, 1);
            else map.put(n, map.get(n) + 1);
        }
        int maxV = -1, maxK = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            if (maxV < entry.getValue()) {
                maxV = entry.getValue();
                maxK = entry.getKey();
            }

        return maxK;
    }
}
