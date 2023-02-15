package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Problem989 {
    //https://leetcode.com/problems/add-to-array-form-of-integer/description/
    public static void main(String[] args) {
        LeetCodeUtils.printList(addToArrayForm(new int[]{1,2,0,0}, 34));
        LeetCodeUtils.printList(addToArrayForm(new int[]{9,9,8}, 1));
        LeetCodeUtils.printList(addToArrayForm(new int[]{9,9,9}, 1));
        LeetCodeUtils.printList(addToArrayForm(new int[]{0}, 0));
    }

    //https://leetcode.com/problems/add-to-array-form-of-integer/solutions/3187797/java-simple-solution/
    //20-30 min
    //Runtime
    //5 ms
    //Beats
    //49.57%
    //Memory
    //43.7 MB
    //Beats
    //74.50%
    static List<Integer> addToArrayForm(int[] num, int k) {
        int[] arr = numToArray(k);
        int[] max = num.length >= arr.length ? num : arr;
        int[] min = num.length >= arr.length ? arr : num;
        int temp = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < min.length; i++) {
            temp += min[min.length - i - 1] + max[max.length - i - 1];
            res.add(temp % 10);
            temp /= 10;
        }
        for (int i = 0; i < max.length - min.length; i++) {
            temp += max[max.length - min.length - i - 1];
            res.add(temp % 10);
            temp /= 10;
        }
        if (temp > 0) res.add(temp);
        Collections.reverse(res);
        return res;
    }

    private static int[] numToArray(int k) {
        Stack<Integer> stack = new Stack<>();
        while (k > 0) {
            stack.push(k % 10);
            k /= 10;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = stack.pop();
        return arr;
    }
}
