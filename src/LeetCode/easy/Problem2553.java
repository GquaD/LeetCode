package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2553 {
    //https://leetcode.com/problems/separate-the-digits-in-an-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[]{13,25})));
    }

    //https://leetcode.com/problems/separate-the-digits-in-an-array/solutions/3162877/java-solution/
    //5 min
    //Runtime
    //4 ms
    //Beats
    //86.99%
    //Memory
    //42.4 MB
    //Beats
    //99%
    static int[] separateDigits(int[] nums) {
        int amount = 0;
        List<List<Integer>> lists = new ArrayList<>();
        for (int n : nums) {
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                list.add(n % 10);
                n /= 10;
            }
            amount += list.size();
            lists.add(list);
        }
        int[] arr = new int[amount];
        int count = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                arr[count++] = list.get(i);
            }
        }
        return arr;
    }
}
