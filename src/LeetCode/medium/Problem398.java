package LeetCode.medium;

import java.util.*;

public class Problem398 {
    //https://leetcode.com/problems/random-pick-index/description/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/random-pick-index/solutions/3274674/java-pick-o-1-solution-using-map/
//5 min
//Runtime
//90 ms
//Beats
//65.65%
//Memory
//52.1 MB
//Beats
//44.85%
class Solution1 {
    Map<Integer, List<Integer>> map;
    static Random random = new Random();
    public Solution1(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> ids = new ArrayList<>();
                ids.add(i);
                map.put(key, ids);
            }
        }
    }

    public int pick(int target) {
        List<Integer> ids = map.get(target);
        return ids.get(random.nextInt(ids.size()));
    }
}
