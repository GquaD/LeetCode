package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem1018 {
    //https://leetcode.com/problems/binary-prefix-divisible-by-5
    public static void main(String[] args) {

    }

    //nnn
    //Runtime
    //4
    //ms
    //Beats
    //28.50%
    //Analyze Complexity
    //Memory
    //46.35
    //MB
    //Beats
    //6.36%
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = (temp * 2 + nums[i]) % 10;
            res.add(temp == 0 || temp == 5);
        }
        return res;
    }
}
