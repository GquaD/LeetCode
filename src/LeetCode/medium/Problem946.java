package LeetCode.medium;

import java.util.Stack;

public class Problem946 {
    //https://leetcode.com/problems/validate-stack-sequences/
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(validateStackSequences(new int[]{1,2,3,7,4,5}, new int[]{7,4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2}, new int[]{1,2}));
        System.out.println(validateStackSequences(new int[]{1,2,3}, new int[]{1,3,2}));
    }

    //https://leetcode.com/problems/validate-stack-sequences/solutions/2931216/java-short-solution-using-stack/
    //Runtime
    //5 ms
    //Beats
    //61.18%
    //Memory
    //45.8 MB
    //Beats
    //10.16%
    static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (idx < popped.length && !stack.isEmpty() && popped[idx] == stack.peek()) {
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
