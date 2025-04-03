package LeetCode.easy;

import java.util.List;

public class Problem2855 {
    //https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/solutions/6611706/java-100-faster-solution-explained-by-tb-k0vt/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.66
    //MB
    //Beats
    //72.70%
    public int minimumRightShifts(List<Integer> nums) {
        int id = 0, min = 100;
        for (int i = 0; i < nums.size(); i++) {
            if (min > nums.get(i)) {
                id = i;
                min = nums.get(i);
            }
        }
        int idx = id, count = 1, prev = nums.get(idx++);
        while (count++ < nums.size()) {
            if (nums.get(idx % nums.size()) < prev) return -1;
            prev = nums.get(idx++ % nums.size());
        }
        return (nums.size() - id) % nums.size();
    }
}
