package LeetCode.medium;

import java.util.Stack;

public class Problem2375 {
    //https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
    public static void main(String[] args) {
        System.out.println(smallestNumber("DIIIIIII"));
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }

    //https://leetcode.com/problems/construct-smallest-number-from-di-string/solutions/2876372/java-2ms-solution-using-stack/
    //30 min
    //Runtime
    //2 ms
    //Beats
    //61.27%
    //Memory
    //41.3 MB
    //Beats
    //79.71%
    static String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 9; i >= 1; i--) {
            stack.push(i);
        }
        Stack<Integer> stackTemp = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'I') {
                sb.append(stack.pop());
                while (stackTemp.size() > 0) {
                    sb.append(stackTemp.pop());
                }
            } else {
                if (i - 1 > 0 && pattern.charAt(i - 1) != c) {
                    while (stackTemp.size() > 0) {
                        sb.append(stackTemp.pop());
                    }
                }
                stackTemp.push(stack.pop());
            }
        }
        stackTemp.push(stack.pop());
        while (stackTemp.size() > 0) {
            sb.append(stackTemp.pop());
        }
        return sb.toString();
    }


    static String smallestNumber1(String pattern) {
        char[] arr = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int a = 0, b = 8;
        StringBuilder sb = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            if (c == 'I') {
                sb.append(arr[a++]);
            } else sb.append(arr[b--]);
        }
        return sb.toString();
    }
}
