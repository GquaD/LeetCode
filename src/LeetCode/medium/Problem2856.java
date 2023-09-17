package LeetCode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2856 {
    //https://leetcode.com/problems/minimum-array-length-after-pair-removals/
    public static void main(String[] args) {
        System.out.println(minLengthAfterRemovals(Arrays.asList(1,1,2)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(1,2,3,4,4,4,5,6,7)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(1,2,3,4,4,4,4,4,4,4,5,6,7)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(1,3,4,9)));
        System.out.println(minLengthAfterRemovals(Arrays.asList(2,3,6,9)));
    }

    //https://leetcode.com/problems/minimum-array-length-after-pair-removals/solutions/4056458/java-3-lines-o-n-solution/
    //30-40min
    //Runtime
    //5 ms
    //Beats
    //33.33%
    //Memory
    //58.3 MB
    //Beats
    //66.67%
    static int minLengthAfterRemovals(List<Integer> nums) {
        int half = nums.size() / 2, countPairs = 0, idx = nums.size() % 2 == 0 ? half : half + 1;
        for (int i = 0; i < half; i++)
            if (nums.get(i) < nums.get(idx + i))
                countPairs++;
        return nums.size() - (countPairs * 2);
    }

    static int minLengthAfterRemovals2(List<Integer> nums) {
        Stack<Integer> stack = new Stack<>();
        int half = nums.size() / 2, countPairs = 0;
        for (int i = 0; i < half; i++) stack.push(nums.get(i));
        for (int i = nums.size() - 1; i >= half; i--) {
            if (!stack.isEmpty() && nums.get(i) > stack.peek()) {
                countPairs++;
                stack.pop();
            }
        }
        return nums.size() - (countPairs * 2);

        /*for (int i = 0; i < nums.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(nums.get(i));
                continue;
            }
            if (stack.peek() < nums.get(i)) {
                stack.pop();
            } else {
                stack.push(nums.get(i));
            }
        }*/
        //return stack.size();
    }

    //
    static int minLengthAfterRemovals1(List<Integer> nums) {
        int countEqual = 1, countAllEqual = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == nums.get(i - 1)) {
                countEqual++;
            } else {
                countAllEqual += countEqual == 1 ? 0 : countEqual;
                countEqual = 1;
            }
        }
        int unique = nums.size() - countAllEqual;
        if (unique == 0) return nums.size();
        return Math.max(countAllEqual - unique, nums.size() % 2 == 0 ? 0 : 1);
    }
}
