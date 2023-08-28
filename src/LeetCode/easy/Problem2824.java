package LeetCode.easy;

import java.util.List;

public class Problem2824 {
    //https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
    public static void main(String[] args) {

    }

    //1 min
    //Runtime
    //2 ms
    //Beats
    //98.53%
    //Memory
    //41.2 MB
    //Beats
    //52.75%
    static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size() - 1; i++)
            for (int j = i + 1; j < nums.size(); j++)
                if (nums.get(i) + nums.get(j) < target) count++;
        return count;
    }
}
