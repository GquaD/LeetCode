package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3069 {
    //https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
    public static void main(String[] args) {

    }

    //3min
    //Runtime
    //2
    //ms
    //Beats
    //38.66%
    //of users with Java
    //Memory
    //44.58
    //MB
    //Beats
    //59.94%
    //of users with Java
    static int[] resultArray(int[] nums) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (a.get(a.size() - 1) > b.get(b.size() - 1)) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }

        a.addAll(b);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a.get(i);
        }
        return nums;
    }
}
