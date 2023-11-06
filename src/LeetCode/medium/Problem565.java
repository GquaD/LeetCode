package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem565 {
    //https://leetcode.com/problems/array-nesting/
    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{0,2,1}));
        System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println(arrayNesting(new int[]{0,1,2}));
    }

    //https://leetcode.com/problems/array-nesting/solutions/4256962/java-2-hashsets/
    //10min
    //Runtime
    //114 ms
    //Beats
    //5.40%
    //Memory
    //58 MB
    //Beats
    //48.92%
    static int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>(), visited = new HashSet<>();
        int max = 0, prev;
        for (int i = 0; i < nums.length; i++) {
            prev = i;
            while (!set.contains(nums[prev]) && !visited.contains(nums[prev])) {
                set.add(nums[prev]);
                prev = nums[prev];
            }
            max = Math.max(set.size(), max);
            visited.addAll(set);
            set.clear();
        }
        return max;
    }
}
